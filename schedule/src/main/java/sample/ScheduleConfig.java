package sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/5/1
 * \* Time: 下午5:29
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Configuration
@EnableScheduling
public class ScheduleConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(threadPoolTaskExecutor());
    }

    @Bean(destroyMethod="shutdown")
    public Executor threadPoolTaskExecutor(){
        return Executors.newScheduledThreadPool(100);
    }

}