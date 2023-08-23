package com.mapping.entites;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class AmazonAccount {

	@Id
	private int id;
	
	private String name;
	
	@OneToMany(mappedBy = "amazonAccount", cascade = CascadeType.ALL)
	private List<Items> items;

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
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}

	public AmazonAccount(int id, String name, List<Items> items) {
		super();
		this.id = id;
		this.name = name;
		this.items = items;
	}

	public AmazonAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AmazonAccount [id=" + id + ", name=" + name + ", items=" + items + "]";
	}
	
}
