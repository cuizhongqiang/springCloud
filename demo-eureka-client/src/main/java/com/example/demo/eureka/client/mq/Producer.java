package com.example.demo.eureka.client.mq;

import java.io.IOException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

public class Producer extends Base {

	public void simple(Channel channel) throws IOException {

		channel.queueDeclare("hello", false, false, false, null);

		String message = "simple Hello World!";

		channel.basicPublish("", "simple_queue", null, message.getBytes("UTF-8"));

		System.out.println(" [x] Sent 'Hello World!'");

	}

	public void work(Channel channel) throws IOException {

		channel.queueDeclare("work_queue", true, false, false, null);

		String message = "work Hello World!";

		channel.basicPublish("", "work_queue", MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("UTF-8"));

		System.out.println(" [x] Sent '" + message + "'");

	}

	public void fanout(Channel channel) throws IOException {

		channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);

		String message = "fanout Hello World!";

		channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));

		System.out.println(" [x] Sent '" + message + "'");

	}

	public void direct(Channel channel) throws IOException {

		channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

		String routingKey = "";

		String message = "";

		channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));

		System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");

	}

	public void topic(Channel channel) throws IOException {

		channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

		String routingKey = "";

		String message = "";

		channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));

		System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");

	}
	
	public void rpc(Channel channel) throws IOException {
		
		String callbackQueueName = channel.queueDeclare().getQueue();
		
		String message = "";
		
		BasicProperties props = new BasicProperties
		                            .Builder()
		                            .replyTo(callbackQueueName)
		                            .build();

		channel.basicPublish("", "rpc_queue", props, message.getBytes());
		
	}

}
