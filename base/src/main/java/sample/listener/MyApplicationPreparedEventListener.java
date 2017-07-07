package sample.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/4/17
 * \* Time: 上午11:29
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class MyApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent> {

    private Logger logger = LoggerFactory.getLogger(MyApplicationPreparedEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent applicationPreparedEvent) {
        ConfigurableApplicationContext applicationContext = applicationPreparedEvent.getApplicationContext();

    }
}