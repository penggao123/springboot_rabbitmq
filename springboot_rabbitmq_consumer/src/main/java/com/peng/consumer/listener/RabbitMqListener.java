package com.peng.consumer.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName DirectListener
 * @Description TODO
 * @Author gaopeng
 * @Date 2021/3/25 21:41
 * @Version 1.0
 **/


@Component
//@RabbitListener(queues = "queue1")
public class RabbitMqListener {

//    @RabbitHandler
    @RabbitListener(queues = "boot_queue")
    public void getMsg(Message message) {
        System.out.println("从queue1队列中获取数据"+ message);
    }
}
