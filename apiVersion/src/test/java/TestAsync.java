import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.Application;

import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 18/6/25
 * \* Time: 下午5:01
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= Application.class)
public class TestAsync {

    @Value("${server.test}")
    private String test;

    private static final Pattern COLLECTION_PROPERTY = Pattern
            .compile("\\[(\\d+)\\](\\.\\S+)?");

    @Test
    public void test() {
        String str1 = "1_1";
        Matcher matcher = COLLECTION_PROPERTY.matcher(str1);
        System.out.println(str1);




        Future<String> future = testAsync();
        return;
//        while (true){
//            try{
//                if(future.isDone()){
//                    String str = future.get();
//                    System.out.println(str);
//                    break;
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
    }


    @Async
    public Future<String> testAsync(){
        System.out.println("testAsync");
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AsyncResult<String>("Hello World");
    }

}