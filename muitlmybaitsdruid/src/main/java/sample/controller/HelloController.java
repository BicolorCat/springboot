package sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.datasource.TargetDataSource;
import sample.service.PersonServiceIF;

import java.util.HashMap;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/4/11
 * \* Time: 上午11:47
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@RestController
@RequestMapping(value = "hello")
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "guys")
    @TargetDataSource(name = "reader")
    public String guys(){
        String str = jdbcTemplate.queryForObject("select `name` from person where id = 1",String.class);
        return str;
    }


    @Autowired
    private PersonServiceIF personService;

    @RequestMapping(value = "world")
    public String hello(){
        return personService.getPersonById("1").getName();
    }


    @RequestMapping(value = "update")
    public int update(){
        return personService.updatePersonById(new HashMap<String,Object>() {
            {
                put("id",1);
                put("name","hello");
            }
        });
    }
}