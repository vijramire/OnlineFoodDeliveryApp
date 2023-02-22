package com.food.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.online.model.Item;


@Repository
public interface ItemDAO extends JpaRepository<Item, Integer>{

}
