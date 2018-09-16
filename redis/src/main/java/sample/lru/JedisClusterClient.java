package sample.lru;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/8/24
 * \* Time: 下午6:09
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 * 从集群环境存取值：

 1)、把key作为参数，执行CRC16算法，获取key对应的slot值

 2)、通过该slot值，去slots的map集合中获取jedisPool实例

 3)、通过jedisPool实例获取jedis实例，最终完成redis数据存取工作
 */
public class JedisClusterClient {

    private final String LOCAL = "127.0.0.1";

    private final String PORT_7000 = "7000";
    private final String PORT_7001 = "7001";
    private final String PORT_7002 = "7002";
    private final String PORT_7003 = "7003";
    private final String PORT_7004 = "7004";
    private final String PORT_7005 = "7005";

    private static final JedisClusterClient redisClusterClient = new JedisClusterClient();

    private JedisClusterClient() {}

    public static JedisClusterClient getInstance() {
        return redisClusterClient;
    }

    private JedisPoolConfig getPoolConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(1000);
        config.setMaxIdle(100);
        config.setTestOnBorrow(true);
        return config;
    }


    public void saveRedisCluster() {
        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        jedisClusterNodes.add(new HostAndPort(LOCAL, 7000));
        jedisClusterNodes.add(new HostAndPort(LOCAL, 7001));
        jedisClusterNodes.add(new HostAndPort(LOCAL, 7002));
        jedisClusterNodes.add(new HostAndPort(LOCAL, 7003));
        jedisClusterNodes.add(new HostAndPort(LOCAL, 7004));
        jedisClusterNodes.add(new HostAndPort(LOCAL, 7005));

        JedisCluster jc = new JedisCluster(jedisClusterNodes,getPoolConfig());
        jc.set("cluster", "this is a redis cluster");
        String result = jc.get("cluster");
        System.out.println(result);
    }

    public static void main(String[] args) {
        JedisClusterClient jedisClusterClient = JedisClusterClient.getInstance();
        jedisClusterClient.saveRedisCluster();
    }
}
