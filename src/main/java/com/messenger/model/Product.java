package com.messenger.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="product")
public class Product implements Cloneable {
	
	private Integer productId;
	private String name;
	private String category;
	private Double price;
	private String description;
	private String brand;
	private User user;
	private String url;
	private Integer quantity;
	private Boolean dispay;
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Boolean getDispay() {
		return dispay;
	}

	public void setDispay(Boolean dispay) {
		this.dispay = dispay;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	private  Boolean SoldOut;
	
	
	@ManyToOne
	@JoinColumn(name="userId")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getSoldOut() {
		return SoldOut;
	}

	public void setSoldOut(Boolean soldOut) {
		SoldOut = soldOut;
	}

	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
		}  
}
