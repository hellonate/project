package com.cmos.project.service.impl;

import com.cmos.project.Listener.KafkaSendResultListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.cmos.project.service.IKafkaProducerSV;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class KafkaProducerSVImpl implements IKafkaProducerSV{
	@Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
	@Autowired
	private KafkaSendResultListener sendListener;

	@Override
	public void send(String topic, Object data) {
		kafkaTemplate.setProducerListener(sendListener);
		kafkaTemplate.send(topic, data);
	}

}
