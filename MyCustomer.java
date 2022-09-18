package com.wipro.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class MyCustomer {

	@Id
	private String cust_id;
	
	@Column(name="Name")
	private String cust_name;
	
	@Column(name="Address")
	private String cust_address;
	
	@Column(name="Contact")
	private String cust_phone;
	
	@OneToOne(mappedBy="c1")
	private Bankaccount a1;
	
	
	public MyCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MyCustomer(String cust_id, String cust_name, String cust_address, String cust_phone, Bankaccount a1) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.cust_address = cust_address;
		this.cust_phone = cust_phone;
		this.a1 = a1;
	}

	public String getCust_id() {
		return cust_id;
	}


	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}


	public String getCust_name() {
		return cust_name;
	}


	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}


	public String getCust_address() {
		return cust_address;
	}


	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}


	public String getCust_phone() {
		return cust_phone;
	}


	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	
	public Bankaccount getAccount() {
		return a1;
	}


	public void setAccount(Bankaccount a1) {
		this.a1 = a1;
	}


	@Override
	public String toString() {
		return "MyCustomer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", cust_address=" + cust_address
				+ ", cust_phone=" + cust_phone + ", a1=" + a1 + "]";
	}
	

	
}
