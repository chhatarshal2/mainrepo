package com.messenger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.messenger.model.Product;
import com.messenger.model.User;
import com.messenger.util.Utility;
@Path("/ProductService")
public class ProductService {

	 @POST
	 @Produces(MediaType.APPLICATION_XML)
	 @Consumes(MediaType.APPLICATION_XML)
	 @Path("/upsert/{message}")
	public String addProduct(Product product) {
		Utility.addObject(product);
		return "Success";
	}
	 
	 
	 @GET
	 @Produces(MediaType.APPLICATION_XML)
	 @Path("/{message}")
	public Product getProduct(@PathParam("message") Integer productId) {
		Product product=null;
		product=(Product)Utility.getObjectFromClass(productId,Product.class);
		return product;
	}
	 
	 @GET
	 @Produces(MediaType.APPLICATION_XML)
	 @Path("/Cat/{message}")
	public List<Product> getProduct(@PathParam("message") String categary) {
		Product product=null;
		Map<Object,List<Object>> queryMap=new HashMap<Object,List<Object>>();
		List<Object> proplist=new ArrayList<Object>();
		proplist.add(categary);
		queryMap.put("category",proplist );
		return (List<Product>)Utility.getObjectFromClass(queryMap,Product.class);
		//return product;
	}
	 
	 @GET
	 @Produces(MediaType.APPLICATION_XML)
	 @Path("/Brand/{message}")
	public List<Product> getProductByBrand(@PathParam("message") String brand) {
		Product product=null;
		Map<Object,List<Object>> queryMap=new HashMap<Object,List<Object>>();
		List<Object> proplist=new ArrayList<Object>();
		proplist.add(brand);
		queryMap.put("Brand",proplist );
		return (List<Product>)Utility.getObjectFromClass(queryMap,Product.class);
		//return product;
	}
	 
}
