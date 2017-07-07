package sample.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/5/24
 * \* Time: 下午5:48
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class LRUCache {

    public static void main(String[] args) {
        Map map = new LinkedHashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.get(2);
        map.keySet().forEach(k -> System.out.println(k));
    }

}