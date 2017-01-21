package com.messenger.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.messenger.model.Cart;

@Controller
public class CartController {
	
	
@RequestMapping(value = "/addOnCart",method = RequestMethod.GET)
public ModelAndView addToCart(ModelMap model, @RequestParam Integer productId) {
	ModelAndView modelAndView = new ModelAndView();
	Cart cart=null;
	Map<String,Object> objectsMap=modelAndView.getModel();
	if(objectsMap.get("cart") != null) {
		cart=(Cart)objectsMap.get("cart");
	} else {
		cart=new Cart();
	}
	objectsMap.put("cart", cart);
	return modelAndView;
}

}
