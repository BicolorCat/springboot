package sample.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.Iterator;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/4/17
 * \* Time: 上午11:01
 * \* To change this template use File | Settings | File Templates.
 * \* Description:配置环境事件监听
 * \
 */
public class MyApplicationEnvironmentPrepareEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    private Logger logger = LoggerFactory.getLogger(MyApplicationEnvironmentPrepareEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
        ConfigurableEnvironment configurableEnvironment = applicationEnvironmentPreparedEvent.getEnvironment();
        MutablePropertySources mps = configurableEnvironment.getPropertySources();
        if(mps != null){
           Iterator<PropertySource<?>> iterator = mps.iterator();
           while(iterator.hasNext()){
               PropertySource<?> ps = iterator.next();
               logger.info("ps.getName:{};ps.getSource:{};ps.getClass:{}", ps.getName(), ps.getSource(), ps.getClass());
           }
        }
    }
}