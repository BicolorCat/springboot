import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.Application;
import sample.config.Sender;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 18/4/18
 * \* Time: 下午4:19
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= Application.class)
public class RabbitMQTest {

    @Autowired
    Sender sender;


    @Test
    public void testSend(){
//        sender.send("helloExchange1","hello.queue1","ceshi1");
        sender.send("userExchange","user.queue1","user1");
    }


}