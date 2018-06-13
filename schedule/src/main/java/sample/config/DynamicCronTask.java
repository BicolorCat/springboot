//package sample.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.SchedulingConfigurer;
//import org.springframework.scheduling.config.ScheduledTaskRegistrar;
//import org.springframework.scheduling.config.TriggerTask;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Lazy(false)
//@Component
//@EnableScheduling
//public class DynamicCronTask implements SchedulingConfigurer {
//    private static final Logger logger = LoggerFactory.getLogger(DynamicCronTask.class);
//
//    private String cron = "*/5 * * * * ?";
//
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        List<TriggerTask> triggerTaskList = new ArrayList<TriggerTask>();
//        TriggerTask triggerTask = new TriggerTask(new ChickenTask(),new ChickenTrigger(cron));
//        triggerTaskList.add(triggerTask);
//        taskRegistrar.setTriggerTasksList(triggerTaskList);
////        taskRegistrar.addTriggerTask(new Runnable() {
////            @Override
////            public void run() {
////                // 任务逻辑
////                logger.debug("dynamicCronTask is running...");
////            }
////        }, new Trigger() {
////            @Override
////            public Date nextExecutionTime(TriggerContext triggerContext) {
////                // 任务触发，可修改任务的执行周期
////                CronTrigger trigger = new CronTrigger(cron);
////                Date nextExec = trigger.nextExecutionTime(triggerContext);
////                return nextExec;
////            }
////        });
//    }
//
//}
