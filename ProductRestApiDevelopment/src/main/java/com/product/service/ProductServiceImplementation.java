package com.product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entites.Product;
import com.product.entites.ProductDto;
import com.product.repository.ProductDao;

@Service
public class ProductServiceImplementation implements ProductService {

	@Autowired
	private ProductDao repo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Product dtoToProduct(ProductDto productDto) {
		Product product = this.modelMapper.map(productDto, Product.class);
		return product;
	}

	@Override
	public ProductDto productToDto(Product product) {
		ProductDto productDto = this.modelMapper.map(product, ProductDto.class);
		return productDto;
	}
	
	public List<ProductDto> getProducts()
	{
		List<Product> products = (List<Product>) this.repo.findAll();
		List<ProductDto> productDtos = products.stream().map(product -> this.productToDto(product)).collect(Collectors.toList());
		return productDtos;
	}
	
	@Override
	public ProductDto getSingleProduct(int productId) {
		Product product = repo.findById(productId);
		if(product.equals(null))
			throw new NullPointerException();
		return productToDto(product);
	}

	@Override
	public ProductDto addProduct(ProductDto productDto) {
		Product product = dtoToProduct(productDto);
		Product savedProduct = this.repo.save(product);
		return productToDto(savedProduct);
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto, int productId) {
		Product product = repo.findById(productId);
		
		if(product.equals(null))
			throw new NullPointerException();
		
		product.setId(productDto.getId());
		product.setPrice(productDto.getPrice());
		product.setProductName(productDto.getProductName());
		
		Product savedProduct = repo.save(product);
		ProductDto productDto2 = productToDto(savedProduct);
		return productDto2;
	}

	@Override
	public void deleteSingleProduct(int productId) {
		repo.deleteById((long) productId);
	}

	@Override
	public void deleteAllProduct() {
		repo.deleteAll();
	}

}
