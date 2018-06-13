package sample.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.config.Sender;

import java.util.UUID;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 18/5/2
 * \* Time: 下午2:27
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@RestController
@RequestMapping("mq")
public class MQController {

    @Autowired
    Sender sender;

    @RequestMapping("sendDirect")
    public void testMQSendDirect(){
        sender.send("helloExchange1","hello.queue1","ceshi1");
    }

    @RequestMapping("sendTopic1")
    public void testMQSendTopic1(){
        sender.send("userExchange","user.queue1", UUID.randomUUID().toString()+"123456");
    }

    @RequestMapping("sendTopic2")
    public void testMQSendTopic2(){
        sender.send("userExchange","user.queue2", UUID.randomUUID().toString()+"123456");
    }
}