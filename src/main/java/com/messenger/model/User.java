package com.messenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cascade;

@XmlRootElement
@Entity
@Table(name="user_base")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private Boolean active;
	
	private String description;
	
	private Date created;
	
	private String password;
	
	@OneToMany(targetEntity=Product.class,mappedBy="user",fetch=FetchType.EAGER)
	private List<Product> products;
	
	public List<Product> getProducts() {
		return products;
	}

	/*public void setProducts(List<Product> products) {
		this.products = products;
	}*/
	
	public void addProducts(List<Product> products) {
		if(this.products == null) {
			this.products=new ArrayList<Product>();
		}
		this.getProducts().addAll(products);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
}
