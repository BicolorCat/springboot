package sample.dynamic.service;

import sample.dynamic.entity.TaskInfo;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 18/6/6
 * \* Time: 上午9:57
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public interface JobService {

     List<TaskInfo> list();

     void edit(TaskInfo info);

     void addJob(TaskInfo info);

     void delete(String jobName,String jobGroup);

}