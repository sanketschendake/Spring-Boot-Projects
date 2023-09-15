package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.entites.ProductDto;
import com.product.service.ProductServiceImplementation;

@RestController
public class ProductController {

	@Autowired
	private ProductServiceImplementation productService;

	@GetMapping("/product")
	public List<ProductDto> getAllProductDtos()
	{
		return productService.getProducts();
	}
	
	@GetMapping("/product/{productId}")
	public ProductDto getSingleProduct(@PathVariable Integer productId)
	{
		return productService.getSingleProduct(productId);
	}
	
	@PostMapping("/product")
	public ProductDto addProduct(@RequestBody ProductDto productDto)
	{
		return productService.addProduct(productDto);
	}
	
	@PutMapping("/product/{productId}")
	public ProductDto updateProduct(@RequestBody ProductDto productDto, @PathVariable Integer productId)
	{
		return productService.updateProduct(productDto, productId);
	}
	
	@DeleteMapping("/product/{productId}")
	public ResponseEntity<HttpStatus> deleteSingleProduct(@PathVariable Integer productId)
	{
		try {
			productService.deleteSingleProduct(productId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/product")
	public String deleteProduct()
	{
		productService.deleteAllProduct();
		return "All products deleted";
	}
}
