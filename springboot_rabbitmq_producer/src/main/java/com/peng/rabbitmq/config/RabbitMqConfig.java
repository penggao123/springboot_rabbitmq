package com.peng.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




@Configuration
public class RabbitMqConfig {


    //定义交换器的名称
    public static final String EXCHANGE_NAME = "boot_topic_exchange";

    //定义队列的名称
    public static final String QUEUE_NAME = "boot_queue";

    /**
     * 声明交换机
     * durable：true:持久化  false：不持久化
     * @return
     */
    @Bean(name = "bootExchange")
    public Exchange bootExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();//链式编程
    }


    /**
     * 声明队列
     * @return
     */
    @Bean(name = "bootQueue")
    public Queue bootQueue() {
        return QueueBuilder.durable(QUEUE_NAME).build();

    }

    /**
     * 队列与交换器的绑定
     * @return
     */
    public Binding bindQueueExchange(@Qualifier("bootQueue") Queue queue, @Qualifier("bootExchange") Exchange exchange) {
        //参数解释：该队列与哪个交换机进行绑定，指定的routingkey是什么
        return BindingBuilder.bind(queue).to(exchange).with("boot.#").noargs();
    }


}
