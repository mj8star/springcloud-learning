package com.licerlee.streamhello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * 用于接收rabbitmq消息的消费者
 * 
 * @author liwc
 * @date 2018年10月29日 下午4:31:55 @ SinkReceiver
 */

// 该注解用来指定一个或多个定义了@Input或@Output注解的接口，以此实现对消息通道（Channel）的绑定。
// Sink接口默认实现的对输入消息通道绑定的定义
@EnableBinding(Sink.class)
public class SinkReceiver {

	private static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

	/**
	 * 监听输入
	 * StreamListener：该注解主要定义在方法上，
	 * 作用是将被修饰的方法注册为消息中间件上数据流的事件监听器，
	 * 注解中的属性值对应了监听的消息通道名。
	 * @param payload
	 */
	@StreamListener(Sink.INPUT)
	public void receive(Object payload) {
		// 消费mq中的消息
		logger.info("Received:" + payload);
	}
}
