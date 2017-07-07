package sample;

import com.alibaba.fastjson.JSONReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URI;
import java.util.ArrayList;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/5/1
 * \* Time: 下午5:13
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Component
public class ScheduleTest {

    private static Logger logger = LoggerFactory.getLogger(ScheduleTest.class);

    private static String URL1 = "http://10.18.8.82:8080/weixin/creatTempUser?ssid=zjlib-guest&userip=";

    private volatile  int count = 0;

    @PostConstruct
    public void getLocalIp(){
        try{
            String localIp = InetAddress.getLocalHost().getHostAddress().toString();
            logger.info("本机IP："+localIp);
            URL1 += localIp;//获得本机IP　　
        }catch(Exception e){
            logger.info("Get LocalIp Exception");
        }
    }


    @Scheduled(cron = "0 */20 * * * ?")
    public void scheduleTask(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.trimToSize();
        logger.info("连接第"+count+++"次");
        commonHTTP(URL1);
    }

    public static void commonHTTP(String url) {
        HttpClient httpClient = HttpClients.createDefault();
        try {
                HttpGet httpGet = new HttpGet();
                httpGet.setURI(URI.create(url));
                HttpResponse httpResponse = httpClient.execute(httpGet);
                int status = httpResponse.getStatusLine().getStatusCode();
                if (status == 200) {
                    HttpEntity entity = httpResponse.getEntity();
                    JSONReader jsonReader = new JSONReader(new InputStreamReader(entity.getContent(), "utf-8"));
                    logger.info(jsonReader.readString());
                }
        }catch (Exception e) {
            logger.error("---------请求连接失败-------------",e);
        } finally {
            // 关闭连接 ,释放资源
            httpClient.getConnectionManager().shutdown();
        }
    }
}