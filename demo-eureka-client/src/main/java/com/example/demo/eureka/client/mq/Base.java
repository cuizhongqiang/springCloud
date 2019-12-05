package com.example.demo.eureka.client.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Base {

	protected static final String EXCHANGE_NAME = "logs";

	protected Channel getConnection() throws Exception {

		ConnectionFactory factory = new ConnectionFactory();

		factory.setHost("");

		Connection connection = factory.newConnection();

		Channel channel = connection.createChannel();

		return channel;
	}

}
