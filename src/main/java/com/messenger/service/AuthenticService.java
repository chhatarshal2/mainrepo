package com.messenger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.messenger.model.Product;
import com.messenger.model.User;
import com.messenger.util.Utility;

@Path("/Authentic")
public class AuthenticService {
	
	@POST
	 @Produces(MediaType.TEXT_PLAIN)
	 @Consumes(MediaType.APPLICATION_XML)
	 @Path("/upsert/{message}")
	public String login(User user) {
		String flag="Login Failled";
		//User user=null;
		Map<Object,Object> queryMap=new HashMap<Object,Object>();
		
		queryMap.put("name",user.getName());
		queryMap.put("password",user.getPassword());
		Object object=Utility.getObjectFromClass(queryMap,User.class);
		List<User> listOfUser=null;
		if(object instanceof List) {
			listOfUser=(List<User>)object;
		}
		
		if(listOfUser.size() > 0) {
			return "Login Success";
		}
		return flag;
	}

}
