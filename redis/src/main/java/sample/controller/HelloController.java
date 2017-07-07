package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.service.PersonServiceIF;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/5/7
 * \* Time: 下午3:50
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@RestController
@RequestMapping(value = "hello")
public class HelloController {
    @Autowired
    private PersonServiceIF personService;

    @RequestMapping(value = "world")
    public String hello(){
        return personService.getNameFromDB();
    }
}