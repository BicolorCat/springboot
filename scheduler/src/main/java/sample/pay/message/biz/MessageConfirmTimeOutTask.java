package sample.pay.message.biz;

import com.alibaba.dubbo.config.annotation.Reference;
import sample.pay.message.entity.TransactionMessage;
import sample.pay.message.service.TransactionMessageService;
import sample.pay.order.OrderBiz;
import sample.pay.order.OrderEntity;
import sample.pay.order.OrderStatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/9/10
 * \* Time: 上午11:31
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class MessageConfirmTimeOutTask implements Callable {

    private Logger logger = LoggerFactory.getLogger(MessageConfirmTimeOutTask.class);

    @Reference(version = "1.0.0")
    public TransactionMessageService transactionMessageService;

    @Autowired
    public OrderBiz orderBiz;

    private CountDownLatch countDownLatch;

    private List<TransactionMessage> transactionMessageList;

    private String flag;

    public MessageConfirmTimeOutTask(CountDownLatch countDownLatch, List<TransactionMessage> transactionMessageList){
        this.countDownLatch = countDownLatch;
        this.transactionMessageList = transactionMessageList;
    }

    @Override
    public Object call() throws Exception {
        try{
            sendOrDeleteMessage(transactionMessageList);
        }catch (Exception e){
            logger.error("FAILURE");
            flag = "FAILURE";
        }finally {
            countDownLatch.countDown();
            flag = "SUCCESS";
            return flag;
        }
    }

    public void sendOrDeleteMessage(List<TransactionMessage> transactionMessageList) throws Exception{
        for(TransactionMessage message:transactionMessageList){
            if(ObjectUtils.isEmpty(message)){
                continue;
            }
            String messageId = message.getMessageId();
            OrderEntity orderEntity = orderBiz.getOrderRecord(message.getField1());
            if(orderEntity.getStatus() == OrderStatusEnum.SUCCESS.getStatus()){
                confirmAndSendMessage(messageId);
            }else{
                deleteMessage(messageId);
            }
        }
    }

    public void confirmAndSendMessage(String messageId) throws Exception{
        transactionMessageService.confirmAndSendMessage(messageId);
    }

    public void deleteMessage(String messageId) throws Exception{
        transactionMessageService.deleteMessageByMessageId(messageId);
    }
}