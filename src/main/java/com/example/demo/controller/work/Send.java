package com.example.demo.controller.work;

import com.example.demo.common.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
//一个生产者，两个消费者。 先启动两个消费者，再启动生产者

/*主要解决这样的问题：处理资源密集型任务，并且还要等他完成。有了工作队列，
我们就可以将具体的工作放到后面去做，将工作封装为一个消息，发送到队列中，一个工作进程就可以取出消息并完成工作。
如果启动了多个工作进程，那么工作就可以在多个进程间共享。*/
public class Send {
	private final static String QUEUE_NAME = "test_queue_work";
	public static void main(String[] args) throws Exception {
		//创建连接
		Connection connection = ConnectionUtil.getConnection();
		//获取通道
		Channel channel = connection.createChannel();
		//
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		for (int i = 0; i < 100; i++) {
            // 消息内容
            String message = "" + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");

            Thread.sleep(i * 10);
        }

        channel.close();
        connection.close();
	}
	
}
