package com.messenger.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.messenger.model.Product;
import com.messenger.util.Utility;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/")
public class MainController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String welcome(Model model) {
		Date today = new Date();
		System.out.println("================================ out ===>");
		Product product=new Product();
		product.setBrand("TOMMY");
		product.setCategory("Cloth");
		product.setDescription("This is just demo");
		product.setPrice(new Double(44420.9));
		System.out.println("=================>  "+loadMainData().size());
		model.addAttribute("products", loadMainData());
		//return "hello";
		return "home";
	}
	
	@RequestMapping(value="/Login",method = RequestMethod.GET)
	public String login() {
		String login="login";
		System.out.println("Going.........to.......login");
		return login;		
	}
	
	@RequestMapping(value="/SubmitLogin",method = RequestMethod.GET)
	public String submitLogin() {
		String login="login";
		System.out.println("Going.........to.......sending...........to.....home");
		return "home";		
	}
	
	
	public List<Product> loadMainData() {
		Map<Object,Object> queryMap=new HashMap<Object,Object>();
		queryMap.put("category", "Main");
		return (List<Product>)Utility.getObjectFromClass(queryMap,Product.class);
	}

}
