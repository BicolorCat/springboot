package rocketmq;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/9/2
 * \* Time: 上午11:08
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class RocketMQException extends Exception {

    public RocketMQException() {
        super();
    }

    public RocketMQException(String message) {
        super(message);
    }

    public RocketMQException(String message, Throwable cause) {
        super(message, cause);
    }

    public RocketMQException(Throwable cause) {
        super(cause);
    }

}