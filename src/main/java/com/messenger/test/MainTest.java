package com.messenger.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.messenger.dao.GenericDAO;
import com.messenger.model.Address;
import com.messenger.model.Product;
import com.messenger.model.User;
import com.messenger.util.Utility;

public class MainTest {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		GenericDAO genericDAO = context.getBean(GenericDAO.class);
		SessionFactory object= (SessionFactory)context.getBean("hibernate3AnnotatedSessionFactory");
		
		//new SchemaExport(object).create(true, true);
		Session ssn=object.openSession();
		
		ssn.beginTransaction();
		List<Product> products=ssn.createQuery("from Product where userid is not null").list();
		System.out.println("siz...........of products:;;"+products.size());
		ssn.close();
		
		 ///System.out.println(object);
	}

}
