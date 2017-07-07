//package sample;
//
//import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
//import org.springframework.context.annotation.AdviceMode;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.scheduling.annotation.AsyncConfigurer;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.SchedulingConfigurer;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
//import org.springframework.scheduling.config.ScheduledTaskRegistrar;
//
//import java.util.concurrent.Executor;
//import java.util.concurrent.ThreadPoolExecutor;
//
///**
// * \* Created with IntelliJ IDEA.
// * \* User: biColor
// * \* Date: 17/5/1
// * \* Time: 下午6:45
// * \* To change this template use File | Settings | File Templates.
// * \* Description:
// * \
// */
//@Configuration
//@EnableScheduling
//@EnableAsync(
//        mode = AdviceMode.PROXY,proxyTargetClass = false,
//        order = Ordered.HIGHEST_PRECEDENCE
//)
//public class RootContextConfiguration implements AsyncConfigurer,SchedulingConfigurer {
//    @Bean
//    @Override
//    public Executor getAsyncExecutor() {
//        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
//        scheduler.setPoolSize(100);
//        return scheduler;
//    }
//
//    @Override
//    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
//        return null;
//    }
//
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
//        scheduledTaskRegistrar.setScheduler(getAsyncExecutor());
//    }
//}