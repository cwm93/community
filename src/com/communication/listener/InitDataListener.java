package com.communication.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

import com.communication.executor.processor.InstantiationTracingBeanPostProcessor;
import com.communication.quartz.QuartzManager;

/**
 * 项目启动运行时初始化数据
 *
 */
@WebListener
public class InitDataListener implements ServletContextListener,InitializingBean, ServletContextAware {
	private static final Logger logger = LoggerFactory.getLogger(InstantiationTracingBeanPostProcessor.class);
    
	public InitDataListener() {
      
    }
	
	
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	QuartzManager.shutdownJobs();
    	logger.info("contextDestroyed");
    }

	
    public void afterPropertiesSet() throws java.lang.Exception { 
    	
    	logger.info("afterPropertiesSet");
    }

	
    public void setServletContext(ServletContext arg0)  { 
    	logger.info("setServletContext");
    }

	
    public void contextInitialized(ServletContextEvent arg0)  { 
    	
    	logger.info("contextInitialized");
    }
	
    
}
