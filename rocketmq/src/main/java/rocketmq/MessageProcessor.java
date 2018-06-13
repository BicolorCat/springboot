package rocketmq;


import org.apache.rocketmq.common.message.MessageExt;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/9/2
 * \* Time: 上午10:52
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public interface MessageProcessor {
    public boolean handleMessage(MessageExt messageExt);
}