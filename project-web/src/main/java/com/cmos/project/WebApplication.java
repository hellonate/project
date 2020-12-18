package com.cmos.project;

import org.apache.log4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by xjs
 */
@SpringBootApplication
@EnableScheduling   //开始定时任务扫描
public class WebApplication {

	private static Logger logger = Logger.getLogger(WebApplication.class);
	
	public static void main(String[] args) {
		try {

			SpringApplication.run(WebApplication.class,args);
		} catch (Exception e) {
			logger.error("初始化消费者处理异常-{}", e);
		}
	}

}