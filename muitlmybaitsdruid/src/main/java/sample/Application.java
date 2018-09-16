package sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import sample.datasource.DynamicDatasourceRegister;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/4/23
 * \* Time: 下午1:54
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@SpringBootApplication
@Import(DynamicDatasourceRegister.class)
public class Application  {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}