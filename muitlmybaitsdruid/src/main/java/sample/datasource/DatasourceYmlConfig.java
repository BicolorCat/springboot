package sample.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;
import java.util.TreeMap;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/4/23
 * \* Time: 下午3:01
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
//@Order(-1)
//@Component
@ConfigurationProperties(prefix="spring.datasource")
public class DatasourceYmlConfig {

    private String name;

    private Map<String,String> prop = new TreeMap<String, String>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getProp() {
        return prop;
    }

    public void setProp(Map<String, String> prop) {
        this.prop = prop;
    }
}