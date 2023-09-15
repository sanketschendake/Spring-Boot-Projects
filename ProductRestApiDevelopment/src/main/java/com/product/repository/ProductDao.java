package com.product.repository;

import org.springframework.data.repository.CrudRepository;

import com.product.entites.Product;


public interface ProductDao extends CrudRepository<Product, Long>{

	public Product findById(Integer id);
}
