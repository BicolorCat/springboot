package sample.pay.order;

import java.io.Serializable;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/9/4
 * \* Time: 下午5:40
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class OrderEntity implements Serializable{

    /**
     * 订单状态
     */
    private int status;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}