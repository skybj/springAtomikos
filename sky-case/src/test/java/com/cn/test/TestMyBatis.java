package com.cn.test;


import org.apache.log4j.Logger;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  

 




import org.springframework.transaction.annotation.Transactional;

import com.lava.lavafaq.bean.Person;
import com.lava.lavafaq.service.IPersonService;

 
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration({"classpath*:spring*.xml"})
//如果 extends AbstractTransactionalJUnit4SpringContextTests 所有数据插入和更新操作都会回滚
public class TestMyBatis  {  
   private static Logger logger = Logger.getLogger(TestMyBatis.class);  
   @Autowired  
   private IPersonService personService;
  //junit4的测试类中打事务注解@Transactional，默认会按照@Rollback(true)来进行处理，无论如何都会回滚
  //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
   @Test 
   public void test1()  { 
	    Person person = new Person();	
		person.setMail("114336");
		person.setPassword("114336");
		person.setFlag(true);
		try {
			personService.testRegister(person);
		} catch (Exception e) {
			logger.debug("异常："+e);
		}
		
		logger.debug("personService参数:{}"+personService);
	
   }  
}  