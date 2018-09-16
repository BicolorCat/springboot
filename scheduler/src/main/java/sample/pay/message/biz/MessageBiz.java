package sample.pay.message.biz;

import com.alibaba.dubbo.config.annotation.Reference;
import sample.pay.message.entity.TransactionMessage;
import sample.pay.message.service.TransactionMessageService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/9/4
 * \* Time: 下午4:12
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Component
public class MessageBiz {

    @Reference(version = "1.0.0")
    public TransactionMessageService transactionMessageService;

    /**
     * 按照消息状态和时间获取消息列表
     */
    public List<TransactionMessage> getMessageByStatusAndTime(){
        return transactionMessageService.listMessageByStatusAndTime(new HashMap(){
            {

            }
        });
    }

}