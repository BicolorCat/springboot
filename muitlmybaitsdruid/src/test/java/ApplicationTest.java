import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.Application;
import sample.datasource.TargetDataSource;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/4/23
 * \* Time: 下午6:27
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= Application.class)
public class ApplicationTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    public void testPrimary(){
        testMultiDb();
    }

    @TargetDataSource(name = "reader")
    private void testMultiDb(){
        String str = jdbcTemplate.queryForObject("select `name` from person where id = 1",String.class);
        System.out.println("");
    }

    private void testLog(){
        System.out.println("test");
    }

}