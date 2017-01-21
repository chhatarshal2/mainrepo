package com.messenger.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.messenger.dao.GenericDAO;
import com.messenger.model.Cart;
import com.messenger.model.Message;
import com.messenger.model.Person;
import com.messenger.model.Product;
import com.messenger.model.User;

public class Utility<T> {

public static	Map<String,String> messageServer=new HashMap<String,String>();
	
	@SuppressWarnings("rawtypes")
	private static GenericDAO genericdao=assembledbcon();
	static {
		messageServer.put("1", "One");
		messageServer.put("2", "TWO");
	}
	
	private static ApplicationContext ac;
	
	public static ApplicationContext getAc() {
		return ac;
	}

	public static void setAc(ApplicationContext acq) {
		ac=acq;
	}
	
	public static  String getMessage(String key) {
		return messageServer.get(key);
	}
	
	

	public static List<Message> getAllMessage() {
		List<Message> listOfObject=new ArrayList<Message>();
		listOfObject.add(new Message("10001","This is strict message",new Date(),"Authod1"));
		listOfObject.add(new Message("10002","This is Noramal message",new Date(),"Authod2"));
		return listOfObject;
	}
	/*public static void main(String[] args) {
		System.out.println(getMessage("1"));
	}*/
	@SuppressWarnings({ "rawtypes", "resource" })
	private static GenericDAO assembledbcon() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		setAc(context);
		GenericDAO genericDAO = context.getBean(GenericDAO.class);
		return genericDAO;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object getObject(Object property)  {
		//GenericDAO personDao=assembledbcon();
		return (Object)genericdao.getObjectByProperty(property);		
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object getObjectFromClass(Object property,Object className)  {
		//GenericDAO personDao=assembledbcon();
		if(property instanceof Map) {
			return (Object)genericdao.getObjectListByMap((Map)property,className);	
		}
		return (Object)genericdao.getObjectByProperty(className,property);		
	}
	
	public static void main(String[] args) {
		User user=new User();
		user.setActive(true);
		user.setCreated(new Date());
		user.setDescription("This is just 14 Dec");
		//user.setUserid(1001);
		addObject(user);
	}

	@SuppressWarnings("unchecked")
	public static void addObject(Object object) {
		// TODO Auto-generated method stub
		if(object instanceof Person) {
			genericdao.save((Person)object);
		}
		if(object instanceof User) {
			genericdao.save((User)object);
		}
		if(object instanceof Product) {
			genericdao.save((Product)object);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static void updateObject(Object object) {
		// TODO Auto-generated method stub
		if(object instanceof Person) {
			genericdao.update((Person)object);
		}
		if(object instanceof User) {
			genericdao.update((User)object);
		}
		if(object instanceof Product) {
			genericdao.update((Product)object);
		}
		
	}
	
	
	public static Cart getCart() {
		ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext)getAc();
		Cart cart = context.getBean(Cart.class);
		return cart;
	}

	public static User getUser() {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext)getAc();
		User user = context.getBean(User.class);
		return user;
	}

	public static void saveObject() {
		// TODO Auto-generated method stub
		
	}

	public static void saveObject(User userLogin) {
		// TODO Auto-generated method stub
		
	}

	public static List<Product> deliverableProducts(Map<Object, Object> queryMap, Class<Product> class1) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext)getAc();
		SessionFactory sessionFactory = (SessionFactory)context.getBean("hibernate3AnnotatedSessionFactory");
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Product> products=session.createQuery("from Product where userid is not null").list();
		session.close();
		return products;
	}
}
