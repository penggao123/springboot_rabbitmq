package com.peng.rabbitmq;

import com.peng.rabbitmq.config.RabbitMqConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
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



//    -------------------------------------黑-------------------------------------
//    /**
//     * 直接模式
//     * 参数1：交换机的名称   直接模式的交换器默认为""
//     * 参数2：路由关键字    直接模式的路由关键字为队列的名称
//     * 参数3：发送的消息
//     *
//     *
//     *
//      **/
//    @Test
//    public void sendDirectMeg() {
//
//        rabbitTemplate.convertAndSend("", "queue1", "直接模式发送消息");
//    }
//
//
//    /**
//     * 分裂模式：任何发送到交换器的消息都会被转发至与该交换器绑定所有队列上
//     *  1、可以理解为路由表的模式
//     *  2、这种模式不需要RouteKey(路由key)
//     *  3、这种模式需要提前将交换器和队列进行绑定，一个交换器可以绑定多个队列，一个队列可以同多个交换器进行绑定。
//     *  4、如果接收交换器没有与任何队列绑定，则消息则会被抛弃
//     *
//     */
//    @Test
//    public void testFanout(){
//
//        /**
//         * 参数1：交换器名称  (指定交换器的名称)
//         * 参数2：交路由key (不需要路由关键字)
//         * 参数1：消息（数据）
//         */
//        rabbitTemplate.convertAndSend("penggao", "", "分裂模式发送消息成功");
//
//    }
//
//
//    /**
//     * 主题模式（Topic）
//     */
//    public void testTopic() {
//        //参数一：交换器名称（指定创建交互器名称）
//        //参数二：路由key(数据标签)
//        //参数三：消息（数据）
//        //rabbitTemplate.convertAndSend("exchange-xyz", "user.log", "这是主题类型消息");
//        rabbitTemplate.convertAndSend("exchange-xyz", "order.log", "这是主题类型消息");
//
//    }

    //    -------------------------------------马-------------------------------------


    /**
     * 图灵
     */
    @Test
    public void send() {
//        rabbitTemplate.setMandatory();//用于设置交换机处理失败的模式  为true时，消息到达不了队列时，会将消息重新返回给生产者

        /**
         * return退回机制
         */
//        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
        //参数1：消息对象
        //参数2：错误码
        //参数3：错误信息
        //参数4：交换机
        //参数5：路由key
//            @Override
//            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
//
//            }
//        });

        /**
         * confirm 模式
         */
//        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
//            /**
//             *
//             * @param correlationData  //相关配置信息
//             * @param ack              //交换机 是否成功收到了消息  true:成功   false:失败
//             * @param cause           //失败原因
//             */
//            @Override
//            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//
//            }
//        });
        rabbitTemplate.convertAndSend("boot_topic_exchange", "boot.haha", "boot mq .......");
    }
}
