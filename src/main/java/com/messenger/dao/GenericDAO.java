package com.messenger.dao;

import java.util.List;
import java.util.Map;

import com.messenger.model.Person;

public interface  GenericDAO<T> {

	public void save(T p);
	
	public List<T> list();
	public T getObjectByProperty(T object);
	public T getObjectByProperty(T object,T object2);
	public List<T> getObjectListByMap(Map<Object,Object> properties,T object);
	
	
}
