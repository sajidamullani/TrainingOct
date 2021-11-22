package com.mastek.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mastek.model.Category;


public interface CategoryDao extends JpaRepository<Category, Long>{

}
