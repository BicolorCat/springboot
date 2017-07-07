package sample.datasource;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.bind.YamlConfigurationFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.ClassUtils;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.*;
import java.util.stream.Collectors;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/4/23
 * \* Time: 下午2:45
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class DynamicDatasourceRegister implements EnvironmentAware,ImportBeanDefinitionRegistrar {

    private final String PREFIX = "spring.datasource.";

    private static final String DATA_SOURCE_TYPE_NAMES = "org.apache.tomcat.jdbc.pool.DataSource";

    private Map<String,DataSource> targetDataSource = new HashMap<>();

    @Override
    public void setEnvironment(Environment environment) {
        initDataSource(environment);
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        targetDataSource.keySet().stream().forEach(key -> DynamicDataSourceContextHolder.dataSourceIds.add(key));
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(DynamicDataSource.class);
        beanDefinition.setSynthetic(true);
        MutablePropertyValues mpv = beanDefinition.getPropertyValues();
        mpv.addPropertyValue("targetDataSources", targetDataSource);
        registry.registerBeanDefinition("dataSource", beanDefinition);

    }


    private void initDataSource(Environment environment){
        String[] names = environment.getProperty(PREFIX + "names").split(",");
        List<DatasourceYmlConfig> ymlConfigList = Arrays.asList(names).stream().map(name -> convertToYmlConfig(name,environment)).collect(Collectors.toList());
        buildMultiDataSource(ymlConfigList);
    }

    private DatasourceYmlConfig convertToYmlConfig(String name,Environment environment){
        return new DatasourceYmlConfig(){
            {
                setName(name);
                setProp(new TreeMap<String,String>(){
                    {
                        put("type",environment.getProperty(PREFIX+name+".type"));
                        put("url",environment.getProperty(PREFIX+name+".url"));
                        put("username",environment.getProperty(PREFIX+name+".username"));
                        put("password",environment.getProperty(PREFIX+name+".password"));
                        put("driver-class-name",environment.getProperty(PREFIX+name+".driver-class-name"));
                    }
                });
            }
        };
    }

    private Map<String,DataSource> buildMultiDataSource(List<DatasourceYmlConfig> ymlConfigList){
        Map<String,DataSource> map = new HashMap<>();
        for(DatasourceYmlConfig ymlConfig:ymlConfigList){
            String name = ymlConfig.getName();
            targetDataSource.put(name,buildDataSource(ymlConfig.getProp()));
        }
        return map;
    }

    private DataSource buildDataSource(Map<String,String> prop){
        DataSource result = null;
        try {
//            Class<? extends DataSource> type = (Class<? extends DataSource>)ClassUtils.forName(DATA_SOURCE_TYPE_NAMES,null);
            Class<? extends DataSource> type = (Class<? extends DataSource>)ClassUtils.forName(prop.get("type"),null);
            String url = prop.get("url");
            String username = prop.get("username");
            String password = prop.get("password");
            String driverClassName = prop.get("driver-class-name");
            return DataSourceBuilder.create().type(type).driverClassName(driverClassName).url(url).username(username).password(password).build();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

}