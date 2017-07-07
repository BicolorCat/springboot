package sample.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/4/17
 * \* Time: 上午11:34
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class MyApplicationFailedListener implements ApplicationListener<ApplicationFailedEvent>{


    private Logger logger = LoggerFactory.getLogger(MyApplicationFailedListener.class);

    @Override
    public void onApplicationEvent(ApplicationFailedEvent applicationFailedEvent) {
        Throwable throwable = applicationFailedEvent.getException();
    }
}