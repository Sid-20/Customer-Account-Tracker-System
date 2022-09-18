package com.wipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.Repo.MyCustomerRepo;
import com.wipro.entities.MyCustomer;

@Service
public class MyCustomerServiceImp implements MyCustomerService {
	
	@Autowired
	private MyCustomerRepo crepo;
	
	public MyCustomerServiceImp(MyCustomerRepo crepo)
	{
		this.crepo=crepo;
	}

	@Override
	public MyCustomer addCustomer(MyCustomer c1) {
		this.crepo.save(c1);
		System.out.println("Customer is added to the database");
		return c1;
	}

	@Override
	public List<MyCustomer> getAllCustomers() {
		List<MyCustomer> c1=(List<MyCustomer>) this.crepo.findAll();
	    return c1;
	}

	@Override
	public MyCustomer getCustomerById(String cust_id) {
		MyCustomer c1=crepo.findById(cust_id).get();
		System.out.println("The Customer you got is: "+c1);
		return c1;
	}


	@Override
	public MyCustomer deleteCustomer(String cust_id) {
		MyCustomer c1=crepo.findById(cust_id).get();
		this.crepo.deleteById(cust_id);
		System.out.println("Customer is deleted");
		return c1;
	}

	@Override
	public MyCustomer updateCustomer(MyCustomer c) {
		this.crepo.save(c);
		System.out.println("Customer Record is updated");
		return c;
	}
	
	

}
