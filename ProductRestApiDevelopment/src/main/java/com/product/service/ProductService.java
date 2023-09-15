package com.product.service;

import java.util.List;

import com.product.entites.Product;
import com.product.entites.ProductDto;

public interface ProductService {

	public Product dtoToProduct(ProductDto productDto);
	
	public ProductDto productToDto(Product product);
	
	public List<ProductDto> getProducts();
	
	public ProductDto getSingleProduct(int productId);
	
	public ProductDto addProduct(ProductDto productDto);
	
	public ProductDto updateProduct(ProductDto productDto, int productId);
	
	public void deleteSingleProduct(int productId);
	
	public void deleteAllProduct();
}
