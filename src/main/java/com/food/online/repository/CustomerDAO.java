package com.food.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.online.model.Customer;


@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer>{

}
