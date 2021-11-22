package com.mastek.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mastek.model.Category;

@Service
public interface CategoryService {
	
	public Category createCategory(Category category);
	public Category getCategory(Long id);
	public Category updateCategory(Category category);
	public void deleteCategory(Long id);
	
	public List<Category> getAllCategories();

}
