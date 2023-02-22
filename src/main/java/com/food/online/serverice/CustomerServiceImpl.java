package com.food.online.serverice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.online.exceptions.CustomerException;
import com.food.online.model.Customer;
import com.food.online.repository.CustomerDAO;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDAO customerDAO;
	

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		Optional<Customer> opt = customerDAO.findById(customer.getCustomerId());
		if(opt.isPresent()) {
			throw new CustomerException("Customer already exists..");
		}else {
			return customerDAO.save(customer);
		}
	}


	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		Optional<Customer> opt = customerDAO.findById(customer.getCustomerId());
		if(opt.isPresent()) {
			return customerDAO.save(customer);
		}else {
			throw new CustomerException("No such customer exists..");
		}
	}


	@Override
	public Customer removeCustomerById(Integer customerId) throws CustomerException {
		Optional<Customer> opt = customerDAO.findById(customerId);
		if(opt.isPresent()) {
			Customer customer = opt.get();
			customerDAO.delete(customer);
			return customer;
		}else {
			throw new CustomerException("No Customer found with ID: "+customerId);
		}
	}


	@Override
	public Customer viewCustomer(Integer customerId) throws CustomerException {
		Optional<Customer> opt = customerDAO.findById(customerId);
		if(opt.isPresent()) {
			Customer customer = opt.get();
			return customer;
		}else {
			throw new CustomerException("No Customer found with ID: "+customerId);
		}
	}

}
