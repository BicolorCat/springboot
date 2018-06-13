package rocketmq;


import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/9/2
 * \* Time: 上午10:55
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Component
public class MessageProcessorImpl implements MessageProcessor {
    @Override
    public boolean handleMessage(MessageExt messageExt) {
        System.out.println("receive : " + messageExt.toString());
        System.out.println("consumerId:"+messageExt.getMsgId());
        return true;
    }
}