package rocketmq;

import org.apache.commons.lang.StringUtils;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/9/2
 * \* Time: 上午10:57
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@SpringBootConfiguration
public class RocketMQProducerConfiguration {

    public static final Logger LOGGER = LoggerFactory.getLogger(RocketMQProducerConfiguration.class);
    @Value("${rocketmq.producer.groupName}")
    private String groupName;
    @Value("${rocketmq.producer.namesrvAddr}")
    private String namesrvAddr;
    @Value("${rocketmq.producer.instanceName}")
    private String instanceName;
    @Value("${rocketmq.producer.maxMessageSize}")
    private int maxMessageSize ; //4M
    @Value("${rocketmq.producer.sendMsgTimeout}")
    private int sendMsgTimeout ;

    @Bean
    public DefaultMQProducer getRocketMQProducer() throws RocketMQException {
        if (StringUtils.isBlank(this.groupName)) {
            throw new RocketMQException("groupName is blank");
        }
        if (StringUtils.isBlank(this.namesrvAddr)) {
            throw new RocketMQException("nameServerAddr is blank");
        }
        if (StringUtils.isBlank(this.instanceName)){
            throw new RocketMQException("instanceName is blank");
        }
        DefaultMQProducer producer;
        producer = new DefaultMQProducer(this.groupName);
        producer.setNamesrvAddr(this.namesrvAddr);
        producer.setInstanceName(instanceName);
        producer.setMaxMessageSize(this.maxMessageSize);
        producer.setSendMsgTimeout(this.sendMsgTimeout);
        try {
            producer.start();
            System.out.println();
        } catch (MQClientException e) {
            System.out.println();
            throw new RocketMQException(e);
        }
        return producer;
    }

}