package sample.pay.message.service;

import sample.pay.message.entity.TransactionMessage;
import sample.pay.message.exception.MessageException;

import java.util.List;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/9/3
 * \* Time: 上午11:33
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public interface TransactionMessageService {

    /**
     * 预存消息
     * @param message
     * @return
     * @throws MessageException
     */
    int saveMessageWaitingConfirm(TransactionMessage message) throws MessageException;

    /**
     * 确认并发送消息
     * @param messageId
     * @throws MessageException
     */
    void confirmAndSendMessage(String messageId) throws Exception;

    /**
     *  按照消息Id重新发送消息
     * @param messageId
     * @throws MessageException
     */
    void reSendMessageByMessageId(String messageId) throws MessageException;

    /**
     * 将消息标记为死亡消息.
     */
    void setMessageToAreadlyDead(String messageId) throws MessageException;


    /**
     * 根据消息ID获取消息
     */
    TransactionMessage getMessageByMessageId(String messageId) throws MessageException;

    /**
     * 根据消息ID删除消息
     */
    void deleteMessageByMessageId(String messageId) throws MessageException;

    /**
     * 根据消息状态和时间取出消息
     * @param param
     * @return
     * @throws MessageException
     */
    List<TransactionMessage> listMessageByStatusAndTime(Map<String,Object> param) throws MessageException;

}