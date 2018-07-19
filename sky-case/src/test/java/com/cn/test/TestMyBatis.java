package com.cn.test;

import javax.annotation.Resource;  

import org.apache.log4j.Logger;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  

 

import com.lava.lavafaq.bean.Person;
import com.lava.lavafaq.service.IPersonService;

 
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration({ "classpath*:spring*.xml"})
public class TestMyBatis {  
   private static Logger logger = Logger.getLogger(TestMyBatis.class);  
   @Autowired  
   private IPersonService personService;

   @Test  
   public void test1() { 
	    Person person = new Person();	
		person.setMail("114336");
		person.setPassword("114336");
		personService.registerPerson(person)
		logger.debug("personService参数:{}"+personService);
	
   }  
}  