package com.zd.rabbitmq_topic;

/*
 *  Creat by zhoudi on 2019/3/19.
 */

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class QueueConfig_topic {

    final static String message1 = "q_topic_message1";
    final static String message2 = "q_topic_message2";

    /**
     * 创建两个队列：q_topic_message1、q_topic_message2
     */
    @Bean
    public Queue queueMessage1(){
        return new Queue(QueueConfig_topic.message1);
    }

    @Bean
    public Queue queueMessage2(){
        return new Queue(QueueConfig_topic.message2);
    }

    /**
     * 声明一个Topic类型的交换机,名字为exchange
     */
    @Bean
    TopicExchange exchange(){
        return new TopicExchange("exchange");
    }

    /**
     * 绑定到交换机,并且指定routingKey
     * @param queueMessage1
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage1, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage1).to(exchange).with("topic.message");
    }

    /**
     * 绑定到交换机,不指定routingKey
     * 通配符：topic.#  匹配一个或者多个词:lazy.# 可以匹配lazy.a或者lazy.a.b
     *         topic.* 只能匹配一个词:lazy.* 可以匹配lazy.a或者lazy.b
     * @param queueMessage2
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeMessages(Queue queueMessage2, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage2).to(exchange).with("topic.#");
    }
}
