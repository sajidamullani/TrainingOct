package com.mastek.service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastek.dao.CategoryDao;
import com.mastek.exception.EmptyInputException;
import com.mastek.exception.NoSuchElementException;
import com.mastek.model.Category;
import com.mastek.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	
	@Autowired
	private CategoryDao dao;
	
	@Override
	public Category createCategory(Category category) {
		if(category.getName().isEmpty()||category.getName().length()==0) {
			throw new EmptyInputException("902","Fields blank");
		}
		try {
		return dao.save(category);
		}
		catch(IllegalArgumentException e) {
			throw new EmptyInputException("900","Empty input");
		}
		catch(Exception e) {
			throw new EmptyInputException("901","service error");
		}	}

	@Override
	public Category getCategory(Long id) {
		try {
			return dao.findById(id).get();
			}
			/*catch(NoSuchElementException e) {
				throw new EmptyInputException("905","id mismach");
			}*/
			catch(Exception e) {
				throw new EmptyInputException("906","service error");
			}
	}

	@Override
	public Category updateCategory(Category category) {
		if(category.getName().isEmpty()||category.getName().length()==0) {
			throw new EmptyInputException("902","Fields blank");
		}
		try {
		return dao.save(category);
		}
		catch(IllegalArgumentException e) {
			throw new EmptyInputException("900","Empty input");
		}
		catch(Exception e) {
			throw new EmptyInputException("901","service error");
		}
	}

	@Override
	public void deleteCategory(Long id) {
		try {
			dao.delete(this.getCategory(id));
			}
			/*catch(NoSuchElementException e) {
				throw new EmptyInputException("903","id mismatch");
			}*/
			catch(Exception e) {
				throw new EmptyInputException("904","service error");
			}
	}

	@Override
	public List<Category> getAllCategories() {
		if(dao.findAll().isEmpty()) {
			throw new EmptyInputException("907","List empty");
		}
		List<Category> categories=dao.findAll();
		return categories;	}

}
