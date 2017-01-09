package com.messenger.service;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.messenger.model.User;
import com.messenger.util.Utility;

@Path("/UserService")
public class UserService {

	 @POST
	 @Produces(MediaType.APPLICATION_XML)
	 @Consumes(MediaType.APPLICATION_XML)
	 @Path("/upsert/{message}")
	public String addUser(User user) {
		Utility.addObject(user);
		return "Success";
	}
	 
	 
	 @GET
	 @Produces(MediaType.APPLICATION_XML)
	 @Path("/{message}")
	public User getUser(@PathParam("message") Integer message) {
		User user=null;
		user=(User)Utility.getObjectFromClass(message,User.class);
		return user;
	}
}
