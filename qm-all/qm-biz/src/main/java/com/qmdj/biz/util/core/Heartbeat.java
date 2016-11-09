package com.qmdj.biz.util.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@EnableScheduling
public class Heartbeat {
	private static final Logger log=LoggerFactory.getLogger(Heartbeat.class);
	@Scheduled(cron = "0/7 * * * * ?")
	public void heartbeatTimers() {
		log.info("System's Hearbeat is working.");
	}

}
