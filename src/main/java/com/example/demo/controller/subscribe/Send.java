package com.example.demo.controller.subscribe;

import com.example.demo.common.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
/*1、1个生产者，多个消费者
2、每一个消费者都有自己的一个队列
3、生产者没有将消息直接发送到队列，而是发送到了交换机
4、每个队列都要绑定到交换机
5、生产者发送的消息，经过交换机，到达队列，实现，一个消息被多个消费者获取的目的*/


//消息发送到没有队列绑定的交换机时，消息将丢失，因为，交换机没有存储消息的能力，消息只能存在在队列中。



/*举个最简单的列子吧：大家应该知道公众号吧，如果你自己也玩过公众号就会发现，
你发送一个东西的时候，所有关注你的人都能收到你的消息，这种如果在mq中的实现其实就可以使用这种模式，
生产者其实就可以理解为微信的公众号，然后消费者可以理解为用户，然后关注可以理解为用户绑定的队列。
这样你发送东西的时候，你会将数据发送到你粉丝的队列中，然后不同的粉丝通过不同的队列去取数据，
这样就能达到公众号的效果。*/ 
public class Send {

    private final static String EXCHANGE_NAME = "test_exchange_fanout";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        // 消息内容
        String message = "Hello World!";
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}