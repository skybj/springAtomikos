package com.lava.lavafaq.service;

import javax.servlet.http.HttpSession;

import org.springframework.transaction.annotation.Transactional;

import com.lava.lavafaq.bean.Person;


public interface IPersonService {
	public String registerPerson(Person person);
	
	public String loginPerson(Person person,HttpSession httpSession);

	public boolean activatEmail(Person person);
	 @Transactional(rollbackFor=Exception.class)
	public void testRegister(Person person)throws Exception;

	
}
