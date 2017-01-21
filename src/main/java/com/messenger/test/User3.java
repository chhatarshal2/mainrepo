package com.messenger.test;

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
import com.messenger.test.Product3;




@XmlRootElement
@Entity
@Table(name="usertest")
public class User3 {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private Boolean active;
	
	private String description;
	
	private Date created;
	
	private String password;
	//@Column
   // @ElementCollection(targetClass=Integer.class)
	//@Access(AccessType.FIELD)
	@OneToMany(targetEntity=Product3.class,mappedBy="user",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Product3> products=new ArrayList<Product3>();
	
	
	public List<Product3> getProducts() {
		return products;
	}

	/*public void setProducts(List<Product> products) {
		this.products = products;
	}*/
	
	public void addProducts(List<Product3> products) {
		if(this.products == null) {
			this.products=new ArrayList<Product3>();
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

	public void addProduct(com.messenger.model.Product product1) {
		// TODO Auto-generated method stub
		
	}

	public void addProduct(Product3 product1) {
		// TODO Auto-generated method stub
		this.getProducts().add(product1);
		product1.setUser(this);
		
	}
	
	
}

