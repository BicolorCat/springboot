package com.sample;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 18/8/20
 * \* Time: 下午4:17
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@JobHandler(value="demoJobHandler")
@Component
public class SampleJob extends IJobHandler {
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        System.out.println(1111);
        return new ReturnT<String>("1111");
    }
}