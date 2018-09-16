package sample.pay.order;

import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/9/4
 * \* Time: 下午5:40
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Component
public class OrderBiz {


    /**
     * 按照订单ID返回订单
     * @param orderId
     * @return
     */
    public OrderEntity getOrderRecord(String orderId){
        return new OrderEntity();
    }
}