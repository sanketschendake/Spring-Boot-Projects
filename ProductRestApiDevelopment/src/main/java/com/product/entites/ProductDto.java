package com.product.entites;


public class ProductDto {

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
		
	@Override
	public String toString() {
		return "Product [id=" + productId + ", productName=" + productName + ", price=" + price + "]";
	}
}
