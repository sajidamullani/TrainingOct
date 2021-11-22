package com.mastek.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mastek.model.Product;

public interface ProductDao extends JpaRepository<Product, Long> {
	
	

}