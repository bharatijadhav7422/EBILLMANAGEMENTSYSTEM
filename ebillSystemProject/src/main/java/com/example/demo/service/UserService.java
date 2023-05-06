package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.User;

public interface UserService 
{
	     User findByUsername(String uname);
		public ResponseEntity<?> saveUser(@RequestBody User user) ;
		User updateCustomer(User customer, int customerId);
		List<User> getAllCustomers();
		void deleteCustomer(int customerId);
		User getCustomerById(int customerId);
		User saveCustomer(User customer);
}