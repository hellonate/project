package com.cmos.project.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;


import com.cmos.project.bean.Activity;
import com.cmos.project.bean.PageVisitLog;
import com.cmos.project.bean.UserPrizeLog;
import com.cmos.project.service.IKafkaProducerSV;
import com.cmos.project.task.ConsumeActivityTask;
import com.cmos.project.utils.IDFactory;
import com.cmos.project.utils.ThreadPoolManager;
import org.apache.commons.lang.StringUtils;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/activity")
public class ActivityController {
	private org.slf4j.Logger logger = LoggerFactory.getLogger(ActivityController.class);
	private Logger firstLogger = Logger.getLogger("firstLogger");
	private Logger secondLogger = Logger.getLogger("secondLogger");
	
	@Autowired
	private IKafkaProducerSV kafkaProducerSV;

	@Value("${spring.kafka.name}")
	private String topic;
	
	/**
	 * 页面访问日志接口
	 * @param pageVisitLog
	 * @return
	 */
	@PostMapping("pageVisitLog")
	public Object pageVisitLog(@RequestBody PageVisitLog pageVisitLog) {
		Map<String, Object> result = new HashMap<String, Object>();
		//1.数据校验：活动名称不可为空
		if(StringUtils.isBlank(pageVisitLog.getActivityName())){
			result.put("msg","activityName 不可空");
			result.put("code", -9999);
			return result;
		}
		//2.起线程
		ThreadPoolManager.addThread(()->{
			kafkaProducerSV.send(topic, pageVisitLog.toString());
		});
		//无用注释
		result.put("msg", "成功");
		result.put("code", 0);
		return result;
	}
	
	/**
	 * 用户中奖日志接口
	 * @param userPrizeLog
	 * @return
	 */
	@PostMapping("userPrizeLog")
	public Object userPrizeLog(@RequestBody UserPrizeLog userPrizeLog){
		Map<String, Object> result = new HashMap<String, Object>();
		//1.数据校验：活动名称不可为空
		if(StringUtils.isBlank(userPrizeLog.getActivityName())){
			result.put("msg","activityName 不可空");
			result.put("code", -9999);
			return result;
		}
		//2.起线程
		ThreadPoolManager.addThread(()->{
			kafkaProducerSV.send(topic, userPrizeLog.toString());
		});
		
		result.put("msg", "成功");
		result.put("code", 0);
		return result;
	}
	
	@RequestMapping(value="/saveActivityInfo",method = RequestMethod.GET)
	public  Object saveActivityInfo(Activity activity) {
		String uuid = IDFactory.GetUUID();
		System.out.println(activity.disPlay());
		Map<String, Object> resMap = new HashMap<>();
		if (activity == null) {
			resMap.put("msg", "activity不存在");
			resMap.put("status", "-1");
			return resMap;
		}
		// 添加唯一标识
		activity.setBackUpField1(uuid);
		try {
			ThreadPoolManager.addThread(new ConsumeActivityTask(activity));
			//存入正常日志
			firstLogger.info(activity.disPlay());
			resMap.put("msg", "success");
			resMap.put("status", "1");
		} catch (RejectedExecutionException e) {
			//存入异常日志
			secondLogger.info(activity.disPlay());
			resMap.put("msg", "RejectedExecutionException");
			resMap.put("status", "0");
		}

		return resMap;
	}
}
