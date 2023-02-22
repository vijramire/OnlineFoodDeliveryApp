package com.food.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.online.model.Category;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Integer>{

}
