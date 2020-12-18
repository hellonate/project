package com.cmos.project.task;

import com.cmos.project.bean.Activity;
import com.cmos.project.service.KafkaSender;
import com.cmos.project.utils.SpringUtils;

public class ConsumeActivityTask  implements Runnable{
	private Activity activity;
	
	public ConsumeActivityTask(Activity activity) {
		this.activity = activity;
	}

	@Override
	public void run() {
		KafkaSender kafkaSender = (KafkaSender) SpringUtils.getBean("kafkaSender");
		kafkaSender.send(activity.disPlay());
	}
}
