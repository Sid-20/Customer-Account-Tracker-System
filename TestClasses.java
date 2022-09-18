package com.wipro.testentities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.wipro.entities.Bankaccount;
import com.wipro.entities.MyCustomer;

class TestClasses {

	@Test
	void testCustomer()
	{
		Bankaccount a=null;
		MyCustomer c1=new MyCustomer("T-001","Test-name","Test-address","Test-Phone",a);
		String cust_id="T-001";
		String cust_name="Test-name";
		String cust_address="Test-address";
		String cust_phone="Test-Phone";
		Bankaccount a1=null;
		
		String exp="MyCustomer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", cust_address=" + cust_address
				+ ", cust_phone=" + cust_phone + ", a1=" + a1 + "]";
		assertEquals(exp,c1.toString());
	}
	
	
	@Test
	void testAccount()
	{
		MyCustomer c=null;
		Bankaccount b=new Bankaccount("test-num","test-type",10,"test-date",c);
		String acc_num="test-num";
		String acc_type="test-type";
		int acc_bal=10;
		String acc_date="test-date";
		MyCustomer c1=null;
		
		String exp="Bankaccount [acc_num=" + acc_num + ", acc_type=" + acc_type + ", acc_bal=" + acc_bal + ", acc_date="
				+ acc_date + ", c1=" + c1 + "]";
		assertEquals(exp,b.toString());
	}
	

}
