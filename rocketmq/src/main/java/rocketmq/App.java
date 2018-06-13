package rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/9/2
 * \* Time: 上午11:41
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) throws Exception{
        ApplicationContext context = SpringApplication.run(App.class,args);
        DefaultMQProducer defaultMQProducer = context.getBean(DefaultMQProducer.class);
        Message msg = new Message("TEST",// topic
                "TEST",// tag
                "KKK",//key用于标识业务的唯一性
                ("Hello RocketMQ !!!!!!!!!!" ).getBytes()// body 二进制字节数组
        );
        SendResult result = defaultMQProducer.send(msg);
        System.out.println("produce:"+result.toString());
        System.out.println("ProducerMsgId:"+result.getMsgId());
        DefaultMQPushConsumer consumer = context.getBean(DefaultMQPushConsumer.class);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.subscribe("TEST","TEST");
        consumer.registerMessageListener(
                new MessageListenerConcurrently() {
                    public ConsumeConcurrentlyStatus consumeMessage(
                            List<MessageExt> list,
                            ConsumeConcurrentlyContext Context) {
                        Message msg = list.get(0);
                        System.out.println("<------>");
                        System.out.println(msg.toString());
                        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                    }
                }
        );
        consumer.start();
    }

}