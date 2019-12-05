package com.example.demo.eureka.client.mq;

@FunctionalInterface
public interface MqFun<T> {
	
	public boolean test(T t);
	
	default MqFun<T> andThen(MqFun<? super T> other) {
		return (t) -> test(t) && other.test(t);
	}

}
