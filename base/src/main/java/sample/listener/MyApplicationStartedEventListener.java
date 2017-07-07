package sample.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/4/11
 * \* Time: 下午3:52
 * \* To change this template use File | Settings | File Templates.
 * \* Description:启动监听类
 * \
 */
public class MyApplicationStartedEventListener implements ApplicationListener<ApplicationStartingEvent> {

    private Logger logger = LoggerFactory.getLogger(MyApplicationStartedEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
        SpringApplication springApp = applicationStartingEvent.getSpringApplication();
        springApp.setBannerMode(Banner.Mode.OFF);
        logger.info("==MyApplicationStartedEventListener==");
    }
}