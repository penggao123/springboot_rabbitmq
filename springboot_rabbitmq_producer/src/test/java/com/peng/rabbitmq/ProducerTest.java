package com.peng.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName ProducerTest
 * @Description TODO
 * @Author gaopeng
 * @Date 2021/3/25 21:22
 * @Version 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProducerApplication.class)
public class ProducerTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    /**
     * 直接模式
     * 参数1：交换机的名称   直接模式的交换器默认为""
     * 参数2：路由关键字    直接模式的路由关键字为队列的名称
     * 参数3：发送的消息
     *
     *
     *
      **/
    @Test
    public void sendDirectMeg() {

        rabbitTemplate.convertAndSend("", "queue1", "直接模式发送消息");
    }

}
