package com.wipro.service;

import java.util.List;
import java.util.Optional;

import com.wipro.entities.MyCustomer;

public interface MyCustomerService {
	
	public MyCustomer addCustomer(MyCustomer c1);
	public List<MyCustomer> getAllCustomers();
	public MyCustomer getCustomerById(String cust_id);
	public MyCustomer deleteCustomer(String cust_id);
	public MyCustomer updateCustomer(MyCustomer c);

}
