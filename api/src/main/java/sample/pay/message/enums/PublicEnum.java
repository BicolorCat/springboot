package sample.pay.message.enums;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/9/3
 * \* Time: 下午3:14
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public enum PublicEnum {

    YES("是"),

    NO("否");

    /** 描述 */
    private String desc;

    private PublicEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}