package sample.datasource;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/4/23
 * \* Time: 下午6:02
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Component
@Aspect
@Order(1)
public class DynamicDataSourceAspect {

    @Before("@annotation(targetDataSource)")
    public void changeDataSource(JoinPoint point, TargetDataSource targetDataSource) throws Throwable {
        String dsId = targetDataSource.name();
        if (!DynamicDataSourceContextHolder.containsDataSource(dsId)) {
            System.out.println(targetDataSource.name());
            System.out.println(point.getSignature());
        } else {
            System.out.println();
            DynamicDataSourceContextHolder.setDataSourceType(targetDataSource.name());
        }
    }

    @After("@annotation(targetDataSource)")
    public void restoreDataSource(JoinPoint point, TargetDataSource targetDataSource) {
        DynamicDataSourceContextHolder.clearDataSourceType();
    }
}