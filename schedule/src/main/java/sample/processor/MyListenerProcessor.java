package sample.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import sample.annotation.DynamicJob;
import sample.dynamic.entity.TaskInfo;
import sample.dynamic.service.JobService;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 18/5/28
 * \* Time: 下午7:49
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Component
public class MyListenerProcessor implements BeanPostProcessor {

    @Autowired
    JobService jobService;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        DynamicJob dynamicJob = AnnotationUtils.findAnnotation(bean.getClass(),DynamicJob.class);
        if(null != dynamicJob){
            try{
                String jobGroup = dynamicJob.jobGroup();
                String jobName = dynamicJob.jobName();
                String cronExpression = dynamicJob.cronExpression();
                TaskInfo taskInfo = new TaskInfo();
                taskInfo.setJobName(jobName);
                taskInfo.setJobGroup(jobGroup);
                taskInfo.setCronExpression(cronExpression);
                taskInfo.setJobStatus("1");
                taskInfo.setCreateTime("2018-06-05 16:43:00");
                jobService.addJob(taskInfo);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
//        String jobClassName = bean.toString().split("@")[0];
//        System.out.println(jobClassName);
//        if(jobClassName.contains("New")){
//            System.out.println(11);
//        }
//        Method[] methods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());
//        if (methods != null) {
//            for (Method method : methods) {
//                DynamicJob jobName = AnnotationUtils.findAnnotation(method, DynamicJob.class);
//                if (null != jobName) {
//                    //插入到数据中
//                    try {
////                        String jobClassName = bean.toString().split("@")[0];
//                        TaskInfo taskInfo = new TaskInfo();
//                        taskInfo.setJobName("sample.dynamic.job.NewJob");
//                        taskInfo.setJobGroup("group1");
//                        taskInfo.setCronExpression("*/5 * * * * ?");
//                        taskInfo.setJobStatus("1");
//                        taskInfo.setCreateTime("2018-06-05 16:43:00");
//                        jobService.addJob(taskInfo);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
        return bean;
    }
}