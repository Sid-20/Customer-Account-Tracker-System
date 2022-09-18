package com.wipro.testcontroller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.wipro.Repo.MyCustomerRepo;
import com.wipro.controller.MainController;
import com.wipro.entities.MyCustomer;
import com.wipro.service.BankaccountService;
import com.wipro.service.MyCustomerService;
import com.wipro.service.MyCustomerServiceImp;

@ExtendWith(MockitoExtension.class)
class TestController {
	
;
	
	@Mock
	private MyCustomerServiceImp cs;
	
	@Mock
	private BankaccountService as;
	
	@InjectMocks
	private MainController controller;
	
	
	
	
	@Test
	void testWelcome()
	{
		String test="The Final Project Controller is working";
		String act=controller.welcome();
		assertEquals(test,act);
	}
	
	@Test
	void testAddCustomer()
	{
		MyCustomer c1=new MyCustomer("test-id","test-name","test-phone","test-address",null);		
		when(cs.addCustomer(c1)).thenReturn(c1);
		assertEquals(new MyCustomer("test-id","test-name","test-phone","test-address",null).toString(),c1.toString());
		
		
	}

}
