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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="address_fk")
	private Address address;
	
	
	/*@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(targetEntity=Address.class,mappedBy="user",fetch=FetchType.EAGER)
	private List<Address> addresses;
	*/
	/*public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}*/

	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@OneToMany(targetEntity=Product.class,mappedBy="user",fetch=FetchType.EAGER)
	private List<Product> products=new ArrayList<Product>();
	
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
		for(Product product:products) {
			product.setUser(this);
		}
		this.getProducts().addAll(products);
	}
	
/*	public void addAddresses(List<Address> products) {
		if(this.addresses == null) {
			this.addresses=new ArrayList<Address>();
		}
		this.getAddresses().addAll(addresses);
	}*/

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

	public void addProduct(Product product1) {
		// TODO Auto-generated method stub
		this.getProducts().add(product1);
		product1.setUser(this);
	}
	
}
