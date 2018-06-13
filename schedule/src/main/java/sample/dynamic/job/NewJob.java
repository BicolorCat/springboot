package sample.dynamic.job;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
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
 * \* Time: 上午9:38
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Component
@Order(5)
@DynamicJob(jobGroup = "group1",jobName = "sample.dynamic.job.NewJob",cronExpression = "*/5 * * * * ?")
public class NewJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("New");
    }
}