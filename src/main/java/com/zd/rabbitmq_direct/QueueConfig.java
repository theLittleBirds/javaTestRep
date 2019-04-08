package com.zd.rabbitmq_direct;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 *  Creat by zhoudi on 2019/3/18.
 */

@Configuration
public class QueueConfig {

    /*
     * new Queue("queue1",true)  --->> 创建名为queue1的队列,重启rocketmq服务之后，queue1以及消息都存在
     * new Queue("queue2",false) --->> 创建名为queue2的队列,重启rocketmq服务之后，queue2被删除
     */
    @Bean
    public Queue aMessage() {
        return new Queue("queue1",true);
    }
}
