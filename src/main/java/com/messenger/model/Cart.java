package com.messenger.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private List<Integer> products=new ArrayList<Integer>();
	private BigDecimal amount=new BigDecimal("0.0");
	
	public int getSize() {
		return products.size();
	}
	
	public void addProduct(Integer productId) {
		products.add(productId);
	}
	
	public void removeProduct(Integer productId) {
		if(products.size()>0) {
			products.remove(productId);
		}
	}

	public List<Integer> getProducts() {
		return products;
	}
	public void addAmount(BigDecimal amount) {
			this.amount=this.amount.add(amount);
	}

	public BigDecimal getAmount( ) {
		return this.amount;
	}

	public void purgeCart() {
		products.clear();
		amount=amount.ZERO;
	}
	
}
