package com.lava.lavafaq.listenter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * web.xml spring listenter监听器下面配置该监听器
 * @author Administrator
 * 每当有session生成或消亡时，都触发接口中相应的方法，从而实现监听器的效果；
 */
public class HttpSessionListenerImpl implements ServletContextListener,HttpSessionListener,HttpSessionAttributeListener  {
    
	// 声明一个ServletContext对象    
    public static  ServletContext application = null;    
  
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("会话已创建！");
	}
    //session注销即退出、超时时候调用，停止tomcat不会调用
	@SuppressWarnings("rawtypes")
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		   //将用户名称从列表中删除    
        List list = (List) this.application.getAttribute("alluser");  
        String value = (String) event.getSession().getAttribute("uname");    
        list.remove(value);    
        System.out.println("会话销毁：属性移除："+value+"属性已移除");
    	
        this.application.setAttribute("alluser", list);    
		
	}
	//此方法是绑定属性的 ，使用session.setAttribute("uname","实际登录名")时可以通过event.getValue()得到这个session对应的value值
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		 // 如果登陆成功，则将用户名保存在列表之中    
        List list = (List) this.application.getAttribute("alluser");  
        //只记录登录成功
        if("uname".equals(event.getName())&&null!=event.getValue())
        list.add(event.getValue());    
        
        this.application.setAttribute("alluser", list);    
        System.out.println("session("+event.getSession().getId()+")增加属性"+event.getName()+",值为"+event.getValue());
     
		
	}
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
	
		
	}
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		
		
	}
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		 // 容器初始化时，向application中存放一个空的容器    存储人数
		System.out.println("初始化空容器");
        this.application = sce.getServletContext();    
        this.application.setAttribute("alluser", new ArrayList());    
        List list = (List) application.getAttribute("alluser");
    	System.out.println("初始化空容器："+list.size());
		
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
 public static int  getCount(){
	 // HttpSessionListenerImpl listener=new HttpSessionListenerImpl();
	  List list = (List) application.getAttribute("alluser");
	  return list.size() ;
 }
   
}
