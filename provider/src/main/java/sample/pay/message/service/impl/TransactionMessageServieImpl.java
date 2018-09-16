package sample.pay.message.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import sample.pay.message.entity.TransactionMessage;
import sample.pay.message.enums.MessageStatusEnum;
import sample.pay.message.enums.PublicEnum;
import sample.pay.message.exception.MessageException;
import sample.pay.message.service.TransactionMessageService;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/9/3
 * \* Time: 下午12:06
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * 消息子系统各个接口层级实现
 * 包含 1、接受消息并设置为待确认
 *     2、确认并发送消息
 *     3、按照消息ID重新发送消息
 *     4、设置消息为死亡消息
 *     5、按照消息ID获取消息
 *
 */
@Service(version = "1.0.0")
public class TransactionMessageServieImpl implements TransactionMessageService {

    @Autowired
    private DefaultMQProducer producer;

    public int saveMessageWaitingConfirm(TransactionMessage message) throws MessageException {
        if(StringUtils.isEmpty(message)){
            throw new MessageException("message is null");
        }
        message.setEditTime(new Date());
        message.setStatus(MessageStatusEnum.WAITING_CONFIRM.name());
        message.setAreadlyDead(PublicEnum.NO.name());
        message.setMessageSendTimes(0);
//        return transactionMessageDao.insert(message);
        return 1;
    }

    public void confirmAndSendMessage(String messageId) throws Exception {
        final TransactionMessage message = getMessageByMessageId(messageId);
        if (message == null) {
            throw new MessageException("message is null");
        }
        message.setStatus(MessageStatusEnum.SENDING.name());
        message.setEditTime(new Date());
//        transactionMessageDao.update(message);
        //发送消息入Q、
        Message msg = new Message("TEST",
                "TEST",
                "OrderID188",
                JSON.toJSONBytes(message));
        producer.send(msg,new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.printf(sendResult.getMsgId());
            }
            @Override
            public void onException(Throwable e) {
                e.printStackTrace();
            }
        });
    }

    public void reSendMessageByMessageId(String messageId) throws MessageException {

    }

    public void setMessageToAreadlyDead(String messageId) throws MessageException {

    }

    public TransactionMessage getMessageByMessageId(String messageId) throws MessageException {
        return null;
    }

    public void deleteMessageByMessageId(String messageId) throws MessageException {

    }

    public List<TransactionMessage> listMessageByStatusAndTime(Map<String, Object> param) throws MessageException {
        return null;
    }

}