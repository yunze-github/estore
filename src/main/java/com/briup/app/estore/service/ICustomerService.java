package com.briup.app.estore.service;

import com.briup.app.estore.bean.Customer;

public interface ICustomerService {
	
	void register(Customer customer) throws Exception;

	void login(Customer customer) throws Exception;

	Customer findCustomer(Customer customer);
	
	void UpdateCustomer(Customer customer);
	
}
