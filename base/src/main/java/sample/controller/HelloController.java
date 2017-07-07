package sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.service.PersonServiceIF;

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

    @Value("${base.name}")
    private String name;

    @Autowired
    private PersonServiceIF personService;

    @RequestMapping(value = "world")
    public String hello(){
        throw new NullPointerException();
//        return personService.getPersonById("1").getName();
    }

}