package rocketmq;

import org.apache.commons.lang.StringUtils;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/9/2
 * \* Time: 上午11:29
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@SpringBootConfiguration
public class RocketMQConsumerConfiguration {

    @Value("${rocketmq.consumer.namesrvAddr}")
    private String namesrvAddr;
    @Value("${rocketmq.consumer.groupName}")
    private String groupName;
    @Value("${rocketmq.consumer.topic}")
    private String topic;
    @Value("${rocketmq.consumer.tag}")
    private String tag;
    @Value("${rocketmq.consumer.consumeThreadMin}")
    private int consumeThreadMin;
    @Value("${rocketmq.consumer.consumeThreadMax}")
    private int consumeThreadMax;

    @Autowired
    @Qualifier("messageProcessorImpl")
    private MessageProcessor messageProcessor;


    @Bean
    public DefaultMQPushConsumer getRocketMQConsumer() throws RocketMQException {
        if (StringUtils.isBlank(groupName)){
            throw new RocketMQException("groupName is null !!!");
        }
        if (StringUtils.isBlank(namesrvAddr)){
            throw new RocketMQException("namesrvAddr is null !!!");
        }
        if (StringUtils.isBlank(topic)){
            throw new RocketMQException("topic is null !!!");
        }
        if (StringUtils.isBlank(tag)){
            throw new RocketMQException("tag is null !!!");
        }
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(groupName);
        consumer.setNamesrvAddr(namesrvAddr);
        consumer.setConsumeThreadMin(consumeThreadMin);
        consumer.setConsumeThreadMax(consumeThreadMax);
        MessageListener messageListener = new MessageListener();
        messageListener.setMessageProcessor(messageProcessor);
        consumer.registerMessageListener(messageListener);
        try {
            consumer.subscribe(topic,this.tag);
            consumer.start();
            System.out.println("consumer is start !!! groupName:{},topic:{},namesrvAddr:{}"+groupName+topic+namesrvAddr);
        }catch (MQClientException e){
            System.out.println("consumer is failed !!! groupName:{},topic:{},namesrvAddr:{}"+groupName+topic+namesrvAddr);
            throw new RocketMQException(e);
        }
        return consumer;
    }


}