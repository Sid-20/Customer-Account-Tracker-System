package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entities.Bankaccount;
import com.wipro.entities.MyCustomer;
import com.wipro.service.BankaccountService;
import com.wipro.service.MyCustomerService;

@RestController
public class MainController {
	
	@Autowired
	private MyCustomerService cs;
	
	@Autowired
	private BankaccountService as;
	
	public MainController(MyCustomerService cs,BankaccountService as)
	{
		this.cs=cs;
		this.as=as;
	}
	
	@PostMapping("/welcome")
	public String welcome() 
	{
		return "The Final Project Controller is working";
	}
	
	@PostMapping("/addCustomer")
	public ResponseEntity<HttpStatus> addCustomer(@RequestBody MyCustomer c)
	{
		try
		{
			Bankaccount b=c.getAccount();
			Bankaccount b1=addAccount(b);
			this.cs.addCustomer(c);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping("/showAllCustomers")
	public List<MyCustomer> getAllCustomer()
	{
		System.out.println("Trying to get all customers .....");
		List<MyCustomer> l1=cs.getAllCustomers();
		return l1;
	}
	
	@GetMapping("/getCustomer")
	public MyCustomer getCustomerById(@RequestParam("cust_id") String cust_id)
	{
		MyCustomer c1=cs.getCustomerById(cust_id);
		return c1;
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<HttpStatus> updateCustomer(@RequestBody MyCustomer c)
	{
		try
		{
			MyCustomer c1=this.cs.updateCustomer(c);
			Bankaccount b1=updateAccount(c1.getAccount());
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") String cust_id)
	{
		try
		{
			MyCustomer c1=cs.getCustomerById(cust_id);
			Bankaccount b=c1.getAccount();
			Bankaccount b1=deleteAccount(b.getAcc_num());
			MyCustomer c=cs.deleteCustomer(cust_id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/addAccount")
	public Bankaccount addAccount(@RequestBody Bankaccount a)
	{
		Bankaccount a1=as.addAccount(a);
		return a1;
	}
	
	@GetMapping("/showAllAccounts")
	public List<Bankaccount> getAllAccounts()
	{
		List<Bankaccount> a1=as.getAllAccounts();
		return a1;
	}
	
	@GetMapping("/getAccount")
	public Bankaccount getAccountById(@RequestParam("acc_num") String acc_num)
	{
		Bankaccount b1=as.getAccount(acc_num);
		return b1;
	}
	
	@DeleteMapping("/deleteAccount/{acc_num}")
	public Bankaccount deleteAccount(@PathVariable("acc_num") String acc_num)
	{
		Bankaccount b1=as.deleteAccount(acc_num);
		return b1;
	}
	
	@PutMapping("/updateAccount")
	public Bankaccount updateAccount(@RequestBody Bankaccount b)
	{
		Bankaccount b1=this.as.updateAccount(b);
		return b1;
	}
	
	@GetMapping("/doTransaction")
	public ResponseEntity<HttpStatus> doTransaction(@RequestParam("acc_num1") String acc_num1,@RequestParam("acc_num2") String acc_num2,@RequestParam("amount") int amount)
	{
		try
		{
			Bankaccount b1=as.getAccount(acc_num1);
			Bankaccount b2=as.getAccount(acc_num2);
			if(b1.getAcc_bal()>=amount)
			{
				int cur_bal2=b2.getAcc_bal();
				b2.setAcc_bal(amount+cur_bal2);
				int cur_bal1=b1.getAcc_bal();
				b1.setAcc_bal(cur_bal1-amount);
				System.out.println("The Transaction is carried out successfully");
			}
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	

	
}
