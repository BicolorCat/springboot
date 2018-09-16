package sample.pay.message.mq;

import com.alibaba.rocketmq.common.message.MessageExt;
import sample.pay.message.biz.PayCallBackBiz;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/9/2
 * \* Time: 上午10:55
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class MessageProcessorImpl implements MessageProcessor {

    @Autowired
    private PayCallBackBiz payCallBackBiz;

    @Override
    public boolean handleMessage(MessageExt messageExt) {
        System.out.println("receive : " + messageExt.toString());



        return true;
    }
}