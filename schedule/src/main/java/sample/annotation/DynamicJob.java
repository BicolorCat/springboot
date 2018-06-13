package sample.annotation;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 18/6/5
 * \* Time: 下午8:09
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface DynamicJob {

    String jobGroup();

    String jobName();

    String cronExpression();
}