package com.cmos.project.service;
/**
 * kafka生产者接口
 * @author lishenbo
 *
 */
public interface IKafkaProducerSV {
	void send(String topic, Object data);
}
