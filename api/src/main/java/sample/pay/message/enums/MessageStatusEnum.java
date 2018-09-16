package sample.pay.message.enums;


/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/9/3
 * \* Time: 上午11:34
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public enum  MessageStatusEnum {

    WAITING_CONFIRM("待确认"),

    SENDING("发送中");

    private String desc;

    private MessageStatusEnum(String desc){
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}