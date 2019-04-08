package com.zd.rabbitmq_header;

/*
 *  Creat by zhoudi on 2019/3/19.
 */

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Component
public class QueueConfig_header {

    /**
     * 创建一个名为q_header的队列
     * @return
     */
    @Bean
    public Queue queue(){
        return new Queue("q_header");
    }

    /**
     * 创建一个名为headerExchange的交换机
     * @return
     */
    @Bean
    public HeadersExchange headersExchange(){
        return new HeadersExchange("headerExchange");
    }

    /**
     * 将队列q_header与交换机headerExchange绑定，并添加消息匹配规则
     * whereAll
     * whereAny
     * @return
     */
    @Bean
    public Binding  headerBinding(){
        Map<String,Object> map = new HashMap<>();
        map.put("header1","value1");
        map.put("header2","value2");
//        return BindingBuilder.bind(queue()).to(headersExchange()).whereAll(map).match();
        return BindingBuilder.bind(queue()).to(headersExchange()).whereAny(map).match();
    }
}
