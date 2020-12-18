package com.cmos.project.Listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;
@Component
public class MyKafkaMessageListener implements MessageListener<String, String>  {
  public final static Logger logger = LoggerFactory.getLogger(MyKafkaMessageListener.class);

  @Override
  public void onMessage(ConsumerRecord<String, String> data) {
  	//拿到数据，处理业务
  	System.out.println("获取数据....");
      System.out.println("data:"+data);
      String topic=data.topic();
      logger.info("topic:"+topic);
      logger.info("partition:"+String.valueOf(data.partition()));
      logger.info("offset:"+String.valueOf(data.offset()));
      logger.info("value:"+data.value());
  }
}