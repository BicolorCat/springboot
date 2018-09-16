package sample.pay.message.schedule;

import sample.pay.message.biz.MessageBiz;
import sample.pay.message.biz.MessageConfirmTimeOutTask;
import sample.pay.message.entity.TransactionMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.concurrent.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/9/4
 * \* Time: 下午3:32
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 */
public class MessageScheduler {

    private Logger logger = LoggerFactory.getLogger(MessageScheduler.class);

    @Autowired
    private MessageBiz messageBiz;

    private ExecutorService executorService;

    private CountDownLatch countDownLatch;

    private static int CPU_COUNT = Runtime.getRuntime().availableProcessors();

    /**
     * 1、从消息表中查询状态为待确认且超时的消息
     * 2、按照消息ID去订单表中确认订单状态
     * 3、以订单状态来发送或者删除消息
     */
    @Scheduled
    public void handleWaitingConfirmTimeOutMessage() throws Exception{
        handleWaitingConfirmMessageTask();
    }

    private void handleWaitingConfirmMessageTask() throws InterruptedException, ExecutionException {
        List<TransactionMessage> transactionMessageList = getTransactionMessages();
        executorService = Executors.newFixedThreadPool(CPU_COUNT);
        int messageSize = transactionMessageList.size();
        int blockSize = messageSize % CPU_COUNT;
        countDownLatch = new CountDownLatch(blockSize);
        for(int i=0;i<messageSize;i++){
            int fromIndex = i,toIndex = i+blockSize;
            Future future = executorService.submit(new MessageConfirmTimeOutTask(countDownLatch,transactionMessageList.subList(fromIndex,toIndex)));
            logger.info("result is:"+String.valueOf(future.get()));
        }
        countDownLatch.await();
    }

    /**
     * 1、从消息表中查询状态为已发送且超时的消息
     * 2、按照消息ID去订单表中
     * @throws Exception
     */
    @Scheduled
    public void handleSendTimeOutMessage() throws Exception{
        handleSendTimeOutMessageTask();
    }

    private void handleSendTimeOutMessageTask() throws InterruptedException, ExecutionException {
        List<TransactionMessage> transactionMessageList = getTransactionMessages();
        int messageSize = transactionMessageList.size();
        int blockSize = getBlockSize(messageSize);
        countDownLatch = new CountDownLatch(blockSize);
        for(int i=0;i<messageSize;i++){
            int fromIndex = i,toIndex = i+blockSize;
            Future future = executorService.submit(new MessageConfirmTimeOutTask(countDownLatch,transactionMessageList.subList(fromIndex,toIndex)));
            logger.info("result is:"+String.valueOf(future.get()));
        }
        countDownLatch.await();
    }

    private int getBlockSize(int messageSize) {
        executorService = Executors.newFixedThreadPool(CPU_COUNT);
        return messageSize % CPU_COUNT;
    }

    private List<TransactionMessage> getTransactionMessages() {
        return messageBiz.getMessageByStatusAndTime();
    }


}