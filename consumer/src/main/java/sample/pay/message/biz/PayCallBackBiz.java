package sample.pay.message.biz;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import sample.pay.message.mq.RocketMQConsumerConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/9/10
 * \* Time: 下午1:56
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class PayCallBackBiz {


    private DefaultMQPushConsumer consumer;

    @PostConstruct
    public void initMqConsumer() {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(RocketMQConsumerConfiguration.class);
        consumer = ctx.getBean(DefaultMQPushConsumer.class);
    }

    /**
     * 1、操作数据库更改回调记录
     * 2、删除在MQ中传输的信息
     */
    public void completePayCallBack(){

    }




}