package com.cmos.project.Listener;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaSendResultListener implements ProducerListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaSendResultListener.class);
    @Override
    public boolean isInterestedInSuccess() {
        return true;
    }

    @Override
    public void onSuccess(String topic, Integer partition, Object key, Object value, RecordMetadata recordMetadata) {
        LOGGER.info("消息发送成功： topic["+topic+"]partition["+partition+"]message["+key+":"+value+"]");
    }

    @Override
    public void onError(String topic, Integer partition, Object key, Object value, Exception exception) {
        LOGGER.info("消息发送失败： topic["+topic+"]partition["+partition+"]message["+key+":"+value+"]", exception.getMessage());
    }


}
