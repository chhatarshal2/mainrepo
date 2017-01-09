package com.messenger.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class MainRestConsumer {
	
	public static void main(String[] args) {
		ClientBuilder cline=ClientBuilder.newBuilder();
		Client clinet=cline.build();
		WebTarget webtarget=clinet.target("http://localhost:8080/messenger/webapi/UserService/2");
		 
		System.out.println(webtarget.request(MediaType.TEXT_XML).get(String.class));
	}

}
