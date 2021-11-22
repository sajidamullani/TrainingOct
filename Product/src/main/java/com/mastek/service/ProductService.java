package com.mastek.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mastek.model.Product;

@Service
public interface ProductService {
	public Product createProduct(Product product);
	public Product getProduct(Long id);
	public Product updateProduct(Product product);
	public void deleteProduct(Long id);
	
	public List<Product> getAllProducts();

}
