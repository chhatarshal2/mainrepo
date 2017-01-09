package com.messenger.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.messenger.model.Message;
import com.messenger.model.Person;
import com.messenger.util.Utility;


@Path("/reso")
public class MessageDistributer {
	
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path("/{message}")
	public String getMessage(@PathParam("message") String message) {
		 System.out.println("============>>>>  "+message);
    return Utility.getMessage(message);
		 ///return "got It";
	}
	 
	 
	 @GET
	 @Produces(MediaType.APPLICATION_XML)
	 @Path("/restro")
	 public List<Message> getAllMessage() {
//		 System.out.println("============>>>>  "+message);
		 System.out.println("This is restro....................");
    return Utility.getAllMessage();
		 ///return "got It";
	}

	 
	 @POST
	 @Produces(MediaType.TEXT_PLAIN)
	 public String getPosted() {
		 return "Posted....";
	 }
	 
	 @GET
	 @Produces(MediaType.APPLICATION_XML)
	 @Path("/person/{message}")
	public Person getPersonDetail(@PathParam("message") Integer message) {
		 return (Person)Utility.getObject(message);
	}
	 
	 
	 @POST
	 @Produces(MediaType.APPLICATION_XML)
	 @Consumes(MediaType.APPLICATION_XML)
	 @Path("/upsert/{message}")
	public String savePersonDetail(Person person) {
		 Utility.addObject(person);
		 return "Success";
	}
	 
	 
}
