package sample.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 18/4/18
 * \* Time: 下午10:03
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Component
public class Receivcer {

    @RabbitListener(queues = "hello.queue1")
    public String processMessage1(String msg) {
        System.out.println(Thread.currentThread().getName() + " 接收到来自hello.queue1队列的消息：" + msg);
        return "ACK";
    }

    @RabbitListener(queues = "hello.queue2")
    public void processMessage2(String msg) {
        System.out.println(Thread.currentThread().getName() + " 接收到来自hello.queue2队列的消息：" + msg);
    }


    @RabbitListener(queues = "user.queue1")
    public String processUserMessage3(String msg) {
        System.out.println(Thread.currentThread().getName() + " 接收到来自user.queue1队列的消息：" + msg);
        return "ACK";
    }

    @RabbitListener(queues = "user.queue2")
    public void processUserMessage4(String msg) {
        System.out.println(Thread.currentThread().getName() + " 接收到来自user.queue2队列的消息：" + msg);
    }

}