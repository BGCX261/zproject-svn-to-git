package com.zmis.core.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class LaunchListener implements ServletContextListener {
	private static Logger logger = Logger.getLogger(LaunchListener.class);
	
	public void contextDestroyed(ServletContextEvent sce) {
		logger.debug("系统关闭...");
	}

	public void contextInitialized(ServletContextEvent sce) {
		logger.debug("系统开始启动...");
	}
	
	
}
