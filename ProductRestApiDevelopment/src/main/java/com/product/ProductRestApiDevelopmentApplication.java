package com.product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.product.entites.Product;
import com.product.entites.ProductDto;

@SpringBootApplication
public class ProductRestApiDevelopmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductRestApiDevelopmentApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
}
