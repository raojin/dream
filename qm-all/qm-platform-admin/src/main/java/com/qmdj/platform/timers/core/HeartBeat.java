package com.qmdj.platform.timers.core;

import java.util.logging.Logger;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 服务运行心跳器
 * 
 * @return
 * @author xw
 * @Date 2016年10月24日14:23:09
 */
@Component
@EnableScheduling
public class HeartBeat {
	Logger LOG = Logger.getGlobal();
	
	@Scheduled(cron = "0/10 * * * * ?")
	public void heart() throws Exception {
		LOG.info("platform is running.");
	}

}
