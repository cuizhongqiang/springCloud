package com.example.demo.eureka.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.eureka.client.mq.MqEntity;
import com.example.demo.eureka.client.mq.MqFun;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Test {

	public static List<MqEntity> filter(List<MqEntity> list, MqFun<MqEntity> mqFun) {
		return list.stream().filter(me -> mqFun.test(me)).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		String[] atp = { "Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer",
				"Andy Murray", "Tomas Berdych", "Juan Martin Del Potro" };
		List<String> players = Arrays.asList(atp);
		players.forEach(player -> System.out.println(player));

		List<MqEntity> list = new ArrayList<>();
		MqEntity me1 = new MqEntity();
		me1.setName("czq");
		me1.setValue("崔忠强");
		list.add(me1);
		MqEntity me2 = new MqEntity();
		me2.setName("lt");
		me2.setValue("李坦");
		list.add(me2);

		System.out.println(filter(list, me -> {
			System.out.println("sasas");
			return me.getName().equals("czq");
		}));

		list.sort((MqEntity a1, MqEntity a2) -> a1.getName().compareTo(a2.getName()));
		list.sort(Comparator.comparing(MqEntity::getName));
		new Thread(() -> {

		});
		String[] strArray = { "a", "c", "b" };
		// 在学完lambda表达式后，如果你想创建一个Comparator实例，你可能会用以下方法：
		Arrays.sort(strArray, (s1, s2) -> s1.compareTo(s2));

		// 你仔细看就会发现整个lambda体其实就只是在调用String类的compareTo()方法而已

		// 因此我们可以使用方法引用的方式来进行简写
		Arrays.sort(strArray, String::compareTo);

	}

	protected Channel getConnection() throws Exception {

		ConnectionFactory factory = new ConnectionFactory();

		factory.setHost("");

		Connection connection = factory.newConnection();

		Channel channel = connection.createChannel();

		return channel;
	}

}
