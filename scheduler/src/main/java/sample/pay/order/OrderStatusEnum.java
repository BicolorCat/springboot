package sample.pay.order;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/9/5
 * \* Time: 上午11:58
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public enum OrderStatusEnum {

    SUCCESS(1),

    FAIULRE(0);

    private int status;

    private OrderStatusEnum(int desc){
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}