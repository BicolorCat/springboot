package sample.datasource;

import java.lang.annotation.*;

/**
 * Created by biColor on 17/4/23.
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String name();
}
