package com.java.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products")
public class ProductDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "product_name", nullable = false)
	@NotEmpty
	@Size(min = 2, message = "productName should have atleast 2 char")
	private String productName;
	
	
	@Column(name = "price")
	private double price;
	
	public ProductDTO() {
		super();
	}
	
	public ProductDTO(String productName, double price) {
		super();
		this.productName = productName;
		this.price = price;
	}
	
	public ProductDTO(long id, String productName, double price) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
}
