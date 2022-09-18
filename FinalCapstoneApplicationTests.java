package com.wipro;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wipro.Repo.BankaccountRepo;
import com.wipro.Repo.MyCustomerRepo;
import com.wipro.controller.MainController;
import com.wipro.entities.Bankaccount;
import com.wipro.entities.MyCustomer;
import com.wipro.service.BankaccountService;
import com.wipro.service.BankaccountServiceImp;
import com.wipro.service.MyCustomerService;
import com.wipro.service.MyCustomerServiceImp;

@SpringBootTest
class FinalCapstoneApplicationTests {
	
	@Mock
	private MyCustomerRepo crepo;
	
	@Mock
	private BankaccountRepo arepo;
	
	@Autowired
	private BankaccountService as;
	
	@Autowired
	private MyCustomerService cs;
	
	
	void setUp()
	{
		this.cs=new MyCustomerServiceImp(this.crepo);
		this.as=new BankaccountServiceImp(this.arepo);
	}
	
	@Test
	void testAccountService()
	{
		MyCustomer c=null;
		Bankaccount b=new Bankaccount("test-num","test-type",10,"test-date",c);
		Bankaccount b1=as.addAccount(b);
		Bankaccount b3=as.updateAccount(new Bankaccount("test-num","test-type",20,"test-date",c));
		Bankaccount b4=as.getAccount(b3.getAcc_num());
		Bankaccount b2=as.deleteAccount(b4.getAcc_num());
		Bankaccount test_b1=new Bankaccount("test-num","test-type",20,"test-date",c);
		assertEquals(test_b1.toString(),b2.toString());
	}
	
	@Test
	void testCustomerService()
	{
		Bankaccount b=null;
		MyCustomer c=new MyCustomer("test-id","test-name","test-address","test-phone",b);
		MyCustomer c1=cs.addCustomer(c);
		MyCustomer c2=cs.updateCustomer(new MyCustomer("test-id","testNameChanged","test-address","test-phone",b));
		MyCustomer c3=cs.getCustomerById(c2.getCust_id());
		MyCustomer c4=cs.deleteCustomer(c3.getCust_id());
		
		MyCustomer test_c4=new MyCustomer("test-id","testNameChanged","test-address","test-phone",b);
		assertEquals(test_c4.toString(),c4.toString());
		
	}
	
	
	
	

}
