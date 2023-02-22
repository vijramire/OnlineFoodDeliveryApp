package com.food.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.online.model.FoodCart;


@Repository
public interface FoodCartDAO extends JpaRepository<FoodCart, Integer>{

}
