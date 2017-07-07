import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.Application;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/4/21
 * \* Time: 下午4:17
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= Application.class)
public class ApplicationTest {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;

    @Test
    public void testPrimary(){
        String str = jdbcTemplate1.queryForObject("select `name` from person where id = 1",String.class);
        System.out.println(str);
    }


}