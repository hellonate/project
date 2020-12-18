package com.cmos.project.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
//@Slf4j
public class KafkaSender {
	@Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
	
	@Value("${spring.kafka.name}")
	private String KafkaName;
    // 发送消息方法
    public void send(Object body) {
        kafkaTemplate.send(KafkaName, body);
    }
}
