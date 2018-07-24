package com.lava.lavafaq.listenter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.lava.lavafaq.service.IPersonService;
/**
 * web.xml spring listenter监听器下面配置该监听器
 * @author Administrator
 *
 */
public class myServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//因为spring监听配置在这个监听上面 ，所以springioc容器已经初始化完毕，所以自定义监听可以获取到bean对象
	  System.out.println("=========自定义监听初始化==============");
	   ApplicationContext context = (ApplicationContext) sce.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE); 
	   IPersonService userService = (IPersonService) context.getBean("personService");
	  System.out.println("========获取到："+userService);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		 System.out.println("=========自定义监听销毁==============");
		
	}

}
