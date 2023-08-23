package com.mapping.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Items {

	@Id
	private int itemId;
	
	private int quantity;
	
	private String name;
	
	@ManyToOne
	private AmazonAccount amazonAccount;

	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AmazonAccount getAmazonAccount() {
		return amazonAccount;
	}
	public void setAmazonAccount(AmazonAccount amazonAccount) {
		this.amazonAccount = amazonAccount;
	}

	public Items(int itemId, int quantity, String name, AmazonAccount amazonAccount) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
		this.name = name;
		this.amazonAccount = amazonAccount;
	}

	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", quantity=" + quantity + ", name=" + name + ", amazonAccount="
				+ amazonAccount + "]";
	}
}
