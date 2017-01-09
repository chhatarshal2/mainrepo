package com.messenger.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.messenger.model.Person;


public class GenericDAOImpl<T> implements GenericDAO<T> {

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	public void save(T p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(p);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<T> list() {
		Session session = this.sessionFactory.openSession();
		List<T> personList = session.createQuery("from Person").list();
		session.close();
		return personList;
	}

	@Override
	public T getObjectByProperty(T object) {
		Session session = this.sessionFactory.openSession();
		Person person=null;
		if(object instanceof Integer) {
		person=(Person)session.createQuery("from Person where id="+(Integer)object).list().get(0); }
		
		if(object instanceof String) {
			person=(Person)session.createQuery("from Person where name='"+(String)object+"'").list().get(0); }
		
		return (T) person;
	}

	@Override
	public T getObjectByProperty(T object, T object2) {
		Session session = this.sessionFactory.openSession();
		T person=null;
		String className="";
		Class cObject=(Class)object;
		if(cObject.getName().endsWith("User")) {
			className="User";
		}
		if(cObject.getName().endsWith("Person")) {
			className="Person";
		}
		if(cObject.getName().endsWith("Product")) {
			className="Product";
		}
		
		if(className.equalsIgnoreCase("Product")) {
			return person=(T)session.createQuery("from "+className+" where category='"+(String)object2+"'").list().get(0); 
		}
		
		if(object2 instanceof Integer) {
		person=(T)session.createQuery("from "+className+" where id="+(Integer)object2).list().get(0); }
		if(object2 instanceof String) {
			person=(T)session.createQuery("from "+className+"  where name="+(String)object2).list().get(0); }
		return  person;
	}

	@Override
	public List<T> getObjectListByMap(Map<Object,Object> properties,T object) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		
		Class cObject=(Class)object;
		String className="";
		if(cObject.getName().endsWith("User")) {
			className="User";
		}
		if(cObject.getName().endsWith("Person")) {
			className="Person";
		}
		if(cObject.getName().endsWith("Product")) {
			className="Product";
		}
		String property="";
		StringBuilder query=new StringBuilder();;
		Set<Object> keys=properties.keySet();
		String value="";
		String queryComplete="";
		int keySize=properties.size();
		int count=1;
		for(Object key:keys) {
			
			if(key instanceof String) {
				property=(String)key;
				if(properties.get(key) instanceof String) {
					if(!queryComplete.startsWith("from ")) {
						queryComplete=queryComplete+"from "+className+" where ";
					}		
					queryComplete=queryComplete+key+"='"+properties.get(key)+"' ";
					if(keySize>count) {
						queryComplete=queryComplete+" and ";
					}
				} else if(properties.get(key) instanceof List) {
					List<Object> valueList=(List<Object>)properties.get(key); 
					int i=1;
					for(Object vaue:valueList) {
						value=value+"'"+(String)vaue+"'";
						if(i != valueList.size()) {
							value=value+",";
						}
					}		
				}
				
							
			}
			count++;
		}
		if(className.equalsIgnoreCase("User")) {
			System.out.println("Going......to.execute.......query......"+queryComplete);
			return session.createQuery(queryComplete).list(); 
		}
		if(className.equalsIgnoreCase("Product")) {
			System.out.println("Going......to.execute.......query......"+queryComplete);
			return session.createQuery(queryComplete).list(); 
		}
		return null;
	}
	
	

}
