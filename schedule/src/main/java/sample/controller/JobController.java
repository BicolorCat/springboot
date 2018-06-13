package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sample.dynamic.entity.TaskInfo;
import sample.dynamic.service.JobService;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 18/5/28
 * \* Time: 下午3:30
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@RestController
@RequestMapping("job")
public class JobController {

    @Autowired
    private JobService jobService;


    @RequestMapping(value = "updateNew")
    @ResponseBody
    public void updateNewJobDetail() throws Exception{
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setJobName("sample.dynamic.job.NewJob");
        taskInfo.setJobGroup("group1");
        taskInfo.setCronExpression("*/20 * * * * ?");
        taskInfo.setJobStatus("1");
        taskInfo.setCreateTime("2018-06-05 16:43:00");
        jobService.edit(taskInfo);
    }

    @RequestMapping(value = "updateWorld")
    @ResponseBody
    public void updateWorldJobDetail() throws Exception{
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setJobName("sample.dynamic.job.WorldJob");
        taskInfo.setJobGroup("group1");
        taskInfo.setCronExpression("*/5 * * * * ?");
        taskInfo.setJobStatus("1");
        taskInfo.setCreateTime("2018-06-05 16:43:00");
        jobService.edit(taskInfo);
    }

    @RequestMapping(value = "deleteNew")
    @ResponseBody
    public void deleteNewJobDetail() throws Exception{
        jobService.delete("sample.dynamic.job.NewJob","group1");
    }


    @RequestMapping(value = "deleteWorld")
    @ResponseBody
    public void deleteWorldJobDetail() throws Exception{
        jobService.delete("sample.dynamic.job.WorldJob","group1");
    }

    @RequestMapping(value = "list")
    @ResponseBody
    public List<TaskInfo> list() {
        return jobService.list();
    }

}