package sample.redis;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.DefaultRedisCachePrefix;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.*;

import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/5/7
 * \* Time: 下午2:38
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Configuration
@EnableCaching
@SuppressWarnings("SpringJavaAutowiringInspection")
public class RedisCacheConfig extends CachingConfigurerSupport implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Value("${cache.prefix}")
    private String prefix;

    @Value("${cache.expire}")
    private int expire;

    @Bean
    @Override
    public KeyGenerator keyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate){
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        redisCacheManager.setCachePrefix(StringUtils.hasText(prefix)?new DefaultRedisCachePrefix(prefix):null);
        redisCacheManager.setUsePrefix(true);
        redisCacheManager.setExpires(parseCacheDuration(applicationContext));
        return redisCacheManager;
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<Object, Object>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    private Map<String,Long> parseCacheDuration(ApplicationContext applicationContext){
        Map<String,Long> cacheExpires = new HashMap<>();
        String[] beanNames = applicationContext.getBeanNamesForType(Object.class);
        Arrays.asList(beanNames).stream().forEach(beanName -> {
            Class clazz = applicationContext.getType(beanName);
            if(null == findAnnotation(clazz, Service.class)){
                return;
            }
            addCacheExpires(clazz, cacheExpires);
        });
        return cacheExpires;
    }

    private void addCacheExpires(final Class clazz, final Map<String, Long> cacheExpires) {
        ReflectionUtils.doWithMethods(clazz, (method) -> {
            ReflectionUtils.makeAccessible(method);
            CacheDuration cacheDuration = findAnnotation(method, CacheDuration.class);
            Cacheable cacheable = findAnnotation(method, Cacheable.class);
            if(cacheable != null){
                Set<String> cacheNames = new HashSet<>(Arrays.asList(cacheable.cacheNames()));
                cacheNames.stream().forEach(cacheName -> cacheExpires.put(cacheName,cacheDuration.duration()));
            }
        });
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}