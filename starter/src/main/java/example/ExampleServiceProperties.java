package example;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/9/3
 * \* Time: 上午9:17
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@ConfigurationProperties("example.service")
public class ExampleServiceProperties {

    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}