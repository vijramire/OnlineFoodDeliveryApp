package com.food.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.online.model.Restaurant;


@Repository
public interface RestaurantDAO extends JpaRepository<Restaurant, Integer>{

}
