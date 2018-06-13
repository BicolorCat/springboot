package sample.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 18/4/18
 * \* Time: 下午3:34
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Configuration
public class RabbitConfig {



    @Bean
    public Queue helloQueue1(){
        return new Queue("hello.queue1",true);
    }


    @Bean
    public Queue helloQueue2(){
        return new Queue("hello.queue2",true);
    }


    @Bean
    public DirectExchange helloExchange1(){
        return new DirectExchange("helloExchange1");
    }

    @Bean
    public Binding bindHelloExchange1(Queue helloQueue1,DirectExchange exchange){
        return BindingBuilder.bind(helloQueue1).to(exchange).withQueueName();
    }



    @Bean
    public Queue topicQueue1(){
        return new Queue("topic.queue1");
    }

    @Bean
    public Queue topicQueue2(){
        return new Queue("topic.queue2");
    }


    @Bean
    public Queue userQueue1(){
        return new Queue("user.queue1");
    }



    @Bean
    public Queue userQueue2(){
        return new Queue("user.queue2");
    }



    @Bean
    public TopicExchange userExchange(){
        return new TopicExchange("userExchange");
    }


    @Bean
    public Binding bindingUserExchange1(Queue userQueue1,TopicExchange userExchange){
        return BindingBuilder.bind(userQueue1).to(userExchange).with("user.queue1");
    }



    @Bean
    public Binding bindingUserExchange2(Queue userQueue2,TopicExchange userExchange){
        return BindingBuilder.bind(userQueue2).to(userExchange).with("user.#");
    }


}