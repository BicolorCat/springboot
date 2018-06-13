package sample.dto;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 18/5/28
 * \* Time: 下午4:13
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class JobDetailDTO {
    /**
     * id
     */
    private String id;
    /**
     * jobName
     */
    private String jobName;
    /**
     * JobClassName
     */
    private String jobClassName;
    /**
     * cronExpression
     */
    private String cronExpression;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobClassName() {
        return jobClassName;
    }

    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }
}