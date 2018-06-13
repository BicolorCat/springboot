package sample.dynamic.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sample.annotation.DynamicJob;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 18/6/4
 * \* Time: 上午9:39
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Component
@Order
@DynamicJob(jobGroup = "group1",jobName = "sample.dynamic.job.WorldJob",cronExpression = "*/20 * * * * ?")
public class WorldJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("World");
    }
}