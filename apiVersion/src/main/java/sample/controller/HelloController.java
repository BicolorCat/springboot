package sample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sample.version.annotation.ApiVersion;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/5/9
 * \* Time: 下午4:46
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @RequestMapping(value = "world1")
    @ApiVersion(1.1f)
    @ResponseBody
    public String hello1(){
        return "1";
    }

    @RequestMapping(value = "world1")
    @ApiVersion(2.1f)
    @ResponseBody
    public String hello2(){
        return "2";
    }


    @RequestMapping(value = "world1")
    @ApiVersion(3.1f)
    @ResponseBody
    public String hello3(){
        return "3";
    }

    @RequestMapping(value = "guys")
    @ApiVersion(3.1f)
    @ResponseBody
    public String guys(){
        return "4";
    }
}