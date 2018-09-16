package sample.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sample.annotation.DynamicJob;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 18/8/8
 * \* Time: 上午11:02
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Component
@Order(5)
@DynamicJob(jobGroup = "group1",jobName = "sample.job.NewJob",cronExpression = "*/5 * * * * ?")
public class NewJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("New");
    }
}