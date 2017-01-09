package com.messenger.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.messenger.dao.GenericDAO;
import com.messenger.util.Utility;

public class MainTest {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring2.xml");
		GenericDAO genericDAO = context.getBean(GenericDAO.class);
		SessionFactory object= (SessionFactory)context.getBean("hibernate3AnnotatedSessionFactory");
		Session ssn=object.openSession();
		User user=new User();
		Product product1=new Product();
		Product product2=new Product();
		List list=new ArrayList();
		list.add(product1);
		user.addProducts(list);
		list=new ArrayList();
		list.add(product2);
		user.addProducts(list);
		ssn.save(user);
		ssn.flush();
		ssn.close();
		
		 ///System.out.println(object);
	}

}
