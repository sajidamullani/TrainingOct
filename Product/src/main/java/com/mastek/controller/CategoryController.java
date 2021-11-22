package com.mastek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastek.model.Category;
import com.mastek.service.CategoryService;
@RestController
@RequestMapping("/api")
public class CategoryController{
	
	 @Autowired
	 CategoryService service;
	 
	 @PostMapping("/category/create")
	 public Category createCategory(@RequestBody Category category){
		return service.createCategory(category);
	 }
	 
	 @PutMapping("/category/update")
	 public Category updateCategory(@RequestBody Category category) {
		 return this.updateCategory(category);
	 }
	 
	 @GetMapping("/category/{id}")
	 public Category getCategory(@PathVariable Long id) {
		 return service.getCategory(id);
	 }
	 
	 @DeleteMapping("/category/{id}")
	 public void deleteCategory(@PathVariable Long id) {
		 service.deleteCategory(id);
	 }
	 
	 @GetMapping("/category")
	 public List<Category> getAllCategories(){
		 return service.getAllCategories();
	 }
	 
	
	
}
