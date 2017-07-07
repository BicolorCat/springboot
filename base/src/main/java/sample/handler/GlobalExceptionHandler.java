package sample.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/5/9
 * \* Time: 上午11:12
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public String exceptionHandler(){
        return "exception";
    }
}