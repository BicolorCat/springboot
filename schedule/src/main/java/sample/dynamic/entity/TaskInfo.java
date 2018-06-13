package sample.dynamic.entity;

import java.io.Serializable;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 18/6/5
 * \* Time: 上午11:49
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class TaskInfo implements Serializable {

    private String jobName;
    private String jobGroup;
    private String jobDescription;
    private String jobStatus;
    private String cronExpression;
    private String createTime;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}