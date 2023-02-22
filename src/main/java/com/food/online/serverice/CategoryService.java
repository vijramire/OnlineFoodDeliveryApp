package com.food.online.serverice;

import java.util.List;

import com.food.online.exceptions.CategoryException;
import com.food.online.model.Category;

public interface CategoryService {
	
	
	public Category addCategory(Category category)throws CategoryException;
	
	public Category updateCategory(Category category)throws CategoryException;
	
	public Category viewCategory(Integer categoryId)throws CategoryException;
	
	public Category removeCategory(Integer categoryId)throws CategoryException;
	
	public List<Category> viewAllCategory()throws CategoryException;

}
