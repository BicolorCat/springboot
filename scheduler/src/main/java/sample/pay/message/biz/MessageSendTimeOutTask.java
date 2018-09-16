package sample.pay.message.biz;

import com.alibaba.dubbo.config.annotation.Reference;
import sample.pay.message.entity.TransactionMessage;
import sample.pay.message.service.TransactionMessageService;
import sample.pay.order.OrderBiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/9/15
 * \* Time: 下午7:07
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class MessageSendTimeOutTask implements Callable {


    private Logger logger = LoggerFactory.getLogger(MessageConfirmTimeOutTask.class);

    @Reference(version = "1.0.0")
    public TransactionMessageService transactionMessageService;

    @Autowired
    public OrderBiz orderBiz;

    private CountDownLatch countDownLatch;

    private List<TransactionMessage> transactionMessageList;

    private String flag;

    public MessageSendTimeOutTask(CountDownLatch countDownLatch, List<TransactionMessage> transactionMessageList){
        this.countDownLatch = countDownLatch;
        this.transactionMessageList = transactionMessageList;
    }

    @Override
    public Object call() throws Exception {
        try{
            for(TransactionMessage message:transactionMessageList){
                reSendMessage(message.getMessageId());
            }
        }catch (Exception e){
            logger.error("FAILURE");
            flag = "FAILURE";
        }finally {
            countDownLatch.countDown();
            flag = "SUCCESS";
            return flag;
        }
    }

    private void reSendMessage(String messageId){
        transactionMessageService.reSendMessageByMessageId(messageId);
    }
}