package com.messenger.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Path;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.messenger.model.Product;
import com.messenger.model.User;
import com.messenger.util.Utility;

import org.springframework.stereotype.Controller;

@Controller
public class ProductListController {
	
	
	@RequestMapping(value = "/ListShoes",method = RequestMethod.GET)
	public ModelAndView ListShoes() {
		Date today = new Date();
		System.out.println("================================ out ===>");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("shoes");    	
    	Map<Object,Object> queryMap=new HashMap<Object,Object>();
		queryMap.put("category","shoes");
		 List<Product> products=(List<Product>)Utility.getObjectFromClass(queryMap,Product.class);
		 System.out.println("Size of List:::: "+products.size());
		 modelAndView.addObject("products",products);
	  	return modelAndView;
	}
	
	@RequestMapping(value = "/ListChappels",method = RequestMethod.GET)
	public String ListChappels(Model model) {
		Date today = new Date();
		System.out.println("================================ out ===>");
		System.out.println("=================>  "+loadMainData().size());
		model.addAttribute("products", loadMainData());
		//return "hello";
		return "chappels";
	}
	
	@RequestMapping(value = "/ListLoafers",method = RequestMethod.GET)
	public String ListLoafers(Model model) {
		Date today = new Date();
		System.out.println("================================ out ===>");
		System.out.println("=================>  "+loadMainData().size());
		model.addAttribute("products", loadMainData());
		//return "hello";
		return "loafers";
	}
	
	@RequestMapping(value = "/ListSandels",method = RequestMethod.GET)
	public String ListSandels(Model model) {
		Date today = new Date();
		System.out.println("================================ out ===>");
		System.out.println("=================>  "+loadMainData().size());
		model.addAttribute("products", loadMainData());
		//return "hello";
		return "sandels";
	}
	
	@RequestMapping(value = "/ListBelts",method = RequestMethod.GET)
	public String ListBelts(Model model) {
		Date today = new Date();
		System.out.println("================================ out ===>");
		System.out.println("=================>  "+loadMainData().size());
		model.addAttribute("products", loadMainData());
		//return "hello";
		return "belts";
	}
	
	@RequestMapping(value = "/ListCaps",method = RequestMethod.GET)
	public String ListCaps(Model model) {
		Date today = new Date();
		System.out.println("================================ out ===>");
		System.out.println("=================>  "+loadMainData().size());
		model.addAttribute("products", loadMainData());
		//return "hello";
		return "caps";
	}
	
	@RequestMapping(value = "/ListSunglasses",method = RequestMethod.GET)
	public String ListSunglasses(Model model) {
		Date today = new Date();
		System.out.println("================================ out ===>");
		System.out.println("=================>  "+loadMainData().size());
		model.addAttribute("products", loadMainData());
		//return "hello";
		return "sunglasses";
	}
	
	@RequestMapping(value = "/ListScarves",method = RequestMethod.GET)
	public String ListScarves(Model model) {
		Date today = new Date();
		System.out.println("================================ out ===>");
		System.out.println("=================>  "+loadMainData().size());
		model.addAttribute("products", loadMainData());
		//return "hello";
		return "scarves";
	}
	
	/*@RequestMapping(value = "/DEMO",method = RequestMethod.GET)
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
		return "products";
	}*/
	
	@RequestMapping(value = "/ListCasual",method = RequestMethod.GET)
	public String ListCasual(Model model) {
		Date today = new Date();
		System.out.println("================================ out ===>");
		System.out.println("=================>  "+loadMainData().size());
		model.addAttribute("products", loadMainData());
		//return "hello";
		return "casual";
	}
	
	@RequestMapping(value = "/ListLuxury",method = RequestMethod.GET)
	public String ListLuxury(Model model) {
		Date today = new Date();
		System.out.println("================================ out ===>");
		System.out.println("=================>  "+loadMainData().size());
		model.addAttribute("products", loadMainData());
		//return "hello";
		return "luxury";
	}
	
	
	@RequestMapping(value = "/ProductDetail",method = RequestMethod.GET)
	public String getProductDetail(Model model) {
		Date today = new Date();
		System.out.println("================================ out ===>");
		System.out.println("=================>  "+loadMainData().size());
		model.addAttribute("products", loadMainData());
		//return "hello";
		return "productDetail";
	}
	
	public List<Product> loadMainData() {
		Map<Object,Object> queryMap=new HashMap<Object,Object>();
		queryMap.put("category", "Main");
		return (List<Product>)Utility.getObjectFromClass(queryMap,Product.class);
	}

}
