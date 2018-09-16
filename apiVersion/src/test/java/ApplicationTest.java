import com.alibaba.fastjson.JSONReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/5/10
 * \* Time: 下午2:01
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class ApplicationTest {

    static String url = "http://localhost:8080/hello/world1";
    final static String version = "3.2";

    public static void main(String[] args) {
        commonHTTP(url);
    }

    public static void commonHTTP(String url) {
        HttpClient httpClient = HttpClients.createDefault();
        try {
            HttpPost httpPost = new HttpPost();
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("version",version));
            UrlEncodedFormEntity httpEntity = new UrlEncodedFormEntity(nvps);
            httpPost.setURI(URI.create(url));
            httpPost.setEntity(httpEntity);
            HttpResponse httpResponse = httpClient.execute(httpPost);
            int status = httpResponse.getStatusLine().getStatusCode();
            if (status == 200) {
                HttpEntity entity = httpResponse.getEntity();
                JSONReader jsonReader = new JSONReader(new InputStreamReader(entity.getContent(), "utf-8"));
                System.out.println(jsonReader.readString());
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接 ,释放资源
            httpClient.getConnectionManager().shutdown();
        }
    }

}