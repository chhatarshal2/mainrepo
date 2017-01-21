package com.messenger.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.messenger.model.Cart;
import com.messenger.model.Product;
import com.messenger.model.User;
import com.messenger.util.Utility;

@Controller
@SessionAttributes("cart")
@Scope("session")
public class ShopController {
	
	
	@RequestMapping(value="/shop",method = RequestMethod.GET)
	public ModelAndView home() {
		String login="shop";
		System.out.println("Going.........to.......login");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("shop");
		Map<Object,Object> queryMap=new HashMap<Object,Object>();
		queryMap.put("category","shoes");
		queryMap.put("dispay",new Integer(1));		
		List<Product> products=(List<Product>)Utility.getObjectFromClass(queryMap,Product.class);
		modelAndView.addObject("products",products);
		return modelAndView;	
	}
	
	@RequestMapping(value="/singleProduct",method = RequestMethod.GET)
	public ModelAndView singleProduct() {
		String login="shop";
		System.out.println("Going.........to.......login");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("single-product");
		Map<Object,Object> queryMap=new HashMap<Object,Object>();
		queryMap.put("category","shoes");
		List<Product> products=(List<Product>)Utility.getObjectFromClass(queryMap,Product.class);
		modelAndView.addObject("products",products);
		return modelAndView;	
	}
	
	@RequestMapping(value="/cart",method = RequestMethod.GET)
	public ModelAndView cart() {
		String login="shop";
		System.out.println("Going.........to.......login");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("cart");
		Map<Object,Object> queryMap=new HashMap<Object,Object>();
		queryMap.put("category","shoes");
		List<Product> products=(List<Product>)Utility.getObjectFromClass(queryMap,Product.class);
		modelAndView.addObject("products",products);
		return modelAndView;	
	}
	
	@RequestMapping(value="/checkout",method = RequestMethod.GET)
	public ModelAndView checkout() {
		String login="shop";
		System.out.println("Going.........to.......login");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("checkout");
		Map<Object,Object> queryMap=new HashMap<Object,Object>();
		queryMap.put("category","shoes");
		List<Product> products=(List<Product>)Utility.getObjectFromClass(queryMap,Product.class);
		modelAndView.addObject("products",products);
		return modelAndView;	
	}
	
	@RequestMapping(value="/home",method = RequestMethod.GET)
	public ModelAndView homePage() {
		String login="shop";
		System.out.println("Going.........to.......login");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		Map<Object,Object> queryMap=new HashMap<Object,Object>();
		queryMap.put("category","shoes");
		List<Product> products=(List<Product>)Utility.getObjectFromClass(queryMap,Product.class);
		modelAndView.addObject("products",products);
		return modelAndView;	
	}
	
	@RequestMapping(value="/AddCart", method=RequestMethod.GET)
	public ModelAndView addToCart(@RequestParam("productId")int id,Model model) {
		String login="shop";
		System.out.println("Going.........to.......login"+id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("single-product");
		Map<Object,Object> queryMap=new HashMap<Object,Object>();
		queryMap.put("productId",id);
		List<Product> products=(List<Product>)Utility.getObjectFromClass(queryMap,Product.class);
		if(products.size() == 1) {
			modelAndView.addObject("product",products.get(0));
		}
		else {
			System.out.println("Need to go on error page either no product exist or multiple product with same id exist");
		}
		return modelAndView;	
	}
	
	@Scope(value="session")
	@RequestMapping(value="/AddToCart", method=RequestMethod.GET)
	public ModelAndView addToCartShowMore(ModelMap model, @RequestParam String productId, 
			@RequestParam String count) {
		String login="shop";
		System.out.println("Your product is =>"+productId+"\tcount => "+count);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("added-cart");	
		Cart cart=Utility.getCart();
		System.out.println("hashcode============== of "+cart.hashCode());
		Map<Object,Object> queryMap=new HashMap<Object,Object>();
		queryMap.put("productId",Integer.parseInt(productId));
		List<Product> products=(List<Product>)Utility.getObjectFromClass(queryMap,Product.class);
		if(products.size() == 1) {
			Product product=products.get(0);
			BigDecimal priceOfProduct=new BigDecimal(product.getPrice().toString());
			cart.addAmount((priceOfProduct.multiply(new BigDecimal(count))));
		}
		else {
			System.out.println("Need to go on error page either no product exist or multiple product with same id exist");
		}
		cart.addProduct(Integer.parseInt(productId));
		modelAndView.addObject("cart",cart);		
		return modelAndView;	
	}
	
	
	@RequestMapping(value="/PlaceOrder", method=RequestMethod.POST)
	public ModelAndView placeOrder() {
		String login="shop";
		System.out.println("Going.........to.......login");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("shop");
		Map<Object,Object> queryMap=new HashMap<Object,Object>();
		User userLogin=Utility.getUser();
		if(userLogin.getId() == 0) {
			modelAndView.setViewName("login");
			return modelAndView;
		} else {
			queryMap.put("id", userLogin.getId());
			userLogin=((List<User>)Utility.getObjectFromClass(queryMap,User.class)).get(0);
		}
		Cart cart=Utility.getCart();
		List<Product> products1=new ArrayList<Product>();
		queryMap=new HashMap<Object,Object>();
		for(Integer productId:cart.getProducts()) {
			queryMap.put("productId", productId);
			List<Product> products=(List<Product>)Utility.getObjectFromClass(queryMap,Product.class);
			products1.addAll(products);			
		}
		for(Product product:products1) {
			try {
				Product clonedProduct=(Product)product.clone();
				clonedProduct.setDispay(false);
				clonedProduct.setUser(userLogin);
				userLogin.addProduct(clonedProduct);
				Utility.addObject(clonedProduct);
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//userLogin.addProducts();
		cart.purgeCart();
		System.out.println("user "+userLogin.getName()+"\t\t\thas bougth\t\t\t"+userLogin.getProducts().size());
		Utility.updateObject(userLogin);
		return modelAndView;	
	}

	
	@RequestMapping(value="/DeliveryAdmin", method=RequestMethod.GET)
	public ModelAndView deliveryAdmin() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("deliveryAdmin");
		Map<Object,Object> queryMap=new HashMap<Object,Object>();
		List<Product> products= (List<Product>)Utility.deliverableProducts(queryMap,Product.class);
		modelAndView.addObject("products",products);
		return modelAndView;
	}
	
	
	public List<Product> loadMainData() {
		Map<Object,Object> queryMap=new HashMap<Object,Object>();
		queryMap.put("category", "Main");
		return (List<Product>)Utility.getObjectFromClass(queryMap,Product.class);
	}
	

}
