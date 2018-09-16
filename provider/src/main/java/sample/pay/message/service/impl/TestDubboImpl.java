package sample.pay.message.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/9/24
 * \* Time: 下午6:49
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Service(version = "1.0.0")
public class TestDubboImpl implements TestDubbo {

    public void justForTest() {
        System.out.println(1);
    }
}