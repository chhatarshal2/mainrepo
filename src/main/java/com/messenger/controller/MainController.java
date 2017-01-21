package com.messenger.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.messenger.model.Cart;
import com.messenger.model.Product;
import com.messenger.model.User;
import com.messenger.util.Utility;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/")
@SessionAttributes("user")
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
		///model.addAttribute("products", loadMainData());
		//model.addAttribute("user", new User());
		//return "hello";
		return "home";
	}
	
	@RequestMapping(value="/Home",method = RequestMethod.GET)
	public String home() {
		String login="login";
		System.out.println("Going.........to.......login");
		System.out.println("=================>  "+loadMainData().size());
		addDefaultCart();
		return "home";	
	}
	
	private void addDefaultCart() {
		// TODO Auto-generated method stub
		Cart cart=Utility.getCart();
	}

	@RequestMapping(value="/Login",method = RequestMethod.GET)
	public String login() {
		String login="login";
		System.out.println("Going.........to.......login");
		return login;		
	}
	
	@RequestMapping(value="/LoginTest",method = RequestMethod.GET)
	public String loginTest() {
		String login="loginTest";
		System.out.println("Going.........to.......login");
		return login;		
	}
	
	 @RequestMapping(value="/Login/welcome",method = RequestMethod.POST)
	    public String printWelcome(ModelMap model, @RequestParam String name, @RequestParam String password) {    
	        // do something with name & password
	        model.addAttribute(name);
	        model.addAttribute(password);
	        System.out.println("==============================================>>>>>>>>>>>>"+name);
	        model.addAttribute("message", "Spring 3 MVC Hello World");
	        return "hello";
	    }
	@Scope(value="session")
	@RequestMapping(value="/SubmitLogin",method = RequestMethod.GET)
	public ModelAndView submitLogin(ModelMap model, @RequestParam String name, 
			@RequestParam String password) {
		String login="login";
		System.out.println("Going.........to.......sending...........to.....home"+name);
		System.out.println("Going.........to.......sending...........to.....home"+password);
		User userLogin=Utility.getUser();
		userLogin.setName(name);
		userLogin.setPassword(password);
		Map<Object,Object> queryMap=new HashMap<Object,Object>();
		queryMap.put("name",name );
		queryMap.put("password",password);
		 
		ModelAndView modelAndView = new ModelAndView();
	    
	    List<Object> users=(List<Object>)Utility.getObjectFromClass(queryMap,User.class);
		if(users.size()>0) {
				modelAndView.setViewName("home");
	        	modelAndView.addObject("user",name);
	        	userLogin.setId(((User) users.get(0)).getId());
	        	return modelAndView;
		}		
		modelAndView.setViewName("login");
    	return modelAndView;	
	}
	
	@Scope(value="session")
	@RequestMapping(value="/LogOut",method = RequestMethod.GET)
	public ModelAndView logOut(ModelMap model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.clear();
    	modelAndView.setViewName("home");
    	
	   return modelAndView;	
	}
	
	
	
	@RequestMapping(value="/SignUp",method = RequestMethod.POST)
	public ModelAndView signUp(ModelMap model, @RequestParam String name, 
			@RequestParam String password) {
		User user=new User();
		user.setName(name);
		user.setPassword(password);
		Utility.addObject(user);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
    	return modelAndView;	
	}
	
	public List<Product> loadMainData() {
		Map<Object,Object> queryMap=new HashMap<Object,Object>();
		queryMap.put("category", "Main");
		return (List<Product>)Utility.getObjectFromClass(queryMap,Product.class);
	}

}
