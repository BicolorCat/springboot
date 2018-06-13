package example;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/9/3
 * \* Time: 上午9:17
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class ExampleService {
    private String prefix;
    private String suffix;

    public ExampleService(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }
    public String wrap(String word) {
        return prefix + word + suffix;
    }
}