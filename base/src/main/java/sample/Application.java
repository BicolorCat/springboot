package sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ClassUtils;
import sample.listener.MyApplicationEnvironmentPrepareEventListener;
import sample.listener.MyApplicationFailedListener;
import sample.listener.MyApplicationPreparedEventListener;
import sample.listener.MyApplicationStartedEventListener;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/4/11
 * \* Time: 上午11:45
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

@SpringBootApplication
public class Application {
    /**
     * @see MyApplicationStartedEventListener
     * @see MyApplicationEnvironmentPrepareEventListener
     * @see MyApplicationPreparedEventListener
     * @see MyApplicationFailedListener
     */
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.addListeners(new MyApplicationStartedEventListener());
        springApplication.addListeners(new MyApplicationEnvironmentPrepareEventListener());
        springApplication.addListeners(new MyApplicationPreparedEventListener());
        springApplication.addListeners(new MyApplicationFailedListener());
        springApplication.run(args);
    }
}