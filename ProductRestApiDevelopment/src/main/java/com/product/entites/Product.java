package com.product.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	private String productName;
	private int price;
	
	public long getId() {
		return productId;
	}
	public void setId(Long id) {
		this.productId = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Product(Long id, String productName, int price) {
		super();
		this.productId = id;
		this.productName = productName;
		this.price = price;
	}
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Product [id=" + productId + ", productName=" + productName + ", price=" + price + "]";
	}
		
}
