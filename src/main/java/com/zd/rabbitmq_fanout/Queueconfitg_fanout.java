package com.zd.rabbitmq_fanout;

/*
 *  Creat by zhoudi on 2019/3/19.
 */

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Queueconfitg_fanout {

    /**
     * 配置三个队列：q_fanout_A、q_fanout_B、q_fanout_C
     * @return
     */
    @Bean
    public Queue MessageA(){
        return  new Queue("q_fanout_A");
    }

    @Bean
    public Queue MessageB(){
        return  new Queue("q_fanout_B");
    }

    @Bean
    public Queue MessageC(){
        return  new Queue("q_fanout_C");
    }

    /**
     * 配置名为fanoutExchange的广播路由器
     * @return
     */
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    /**
     * 将队列MessageA绑定到交换机fanoutExchange上
     * @param MessageA
     * @param fanoutExchange
     * @return
     */
    @Bean
    Binding bindingExchangeA(Queue MessageA, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(MessageA).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue MessageB, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(MessageB).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue MessageC, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(MessageC).to(fanoutExchange);
    }
}
