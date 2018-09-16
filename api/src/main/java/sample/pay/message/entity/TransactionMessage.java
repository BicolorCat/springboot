package sample.pay.message.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/9/3
 * \* Time: 上午11:33
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class TransactionMessage implements Serializable {

    private static final long serialVersionUID = 1757377457814546156L;

    private String id;// 主键ID.

    private Integer version = 0;// 版本号默认为0

    private String status;// 状态 PublicStatusEnum

    private String creater;// 创建人.

    private Date createTime = new Date();// 创建时间.

    private String editor;// 修改人.

    private Date editTime;// 修改时间.

    private String remark;// 描述

    private String messageId;

    private String messageBody;

    private String messageDataType;

    private String consumerQueue;

    private Integer messageSendTimes;

    private String areadlyDead;

    /**
     * 暂时做订单ID
     */
    private String field1;

    private String field2;

    private String field3;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getMessageDataType() {
        return messageDataType;
    }

    public void setMessageDataType(String messageDataType) {
        this.messageDataType = messageDataType;
    }

    public String getConsumerQueue() {
        return consumerQueue;
    }

    public void setConsumerQueue(String consumerQueue) {
        this.consumerQueue = consumerQueue;
    }

    public Integer getMessageSendTimes() {
        return messageSendTimes;
    }

    public void setMessageSendTimes(Integer messageSendTimes) {
        this.messageSendTimes = messageSendTimes;
    }

    public String getAreadlyDead() {
        return areadlyDead;
    }

    public void setAreadlyDead(String areadlyDead) {
        this.areadlyDead = areadlyDead;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }
}