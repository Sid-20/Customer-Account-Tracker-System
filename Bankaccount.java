package com.wipro.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Bankaccount {
	
	@Id
	private String acc_num;
	private String acc_type;
	private int acc_bal;
	private String acc_date;
	
	@OneToOne(cascade=CascadeType.ALL)
	private MyCustomer c1;

	public Bankaccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Bankaccount(String acc_num, String acc_type, int acc_bal, String acc_date, MyCustomer c1) {
		super();
		this.acc_num = acc_num;
		this.acc_type = acc_type;
		this.acc_bal = acc_bal;
		this.acc_date = acc_date;
		this.c1 = c1;
	}

	public String getAcc_num() {
		return acc_num;
	}



	public void setAcc_num(String acc_num) {
		this.acc_num = acc_num;
	}



	public String getAcc_type() {
		return acc_type;
	}



	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}



	public int getAcc_bal() {
		return acc_bal;
	}



	public void setAcc_bal(int acc_bal) {
		this.acc_bal = acc_bal;
	}



	public String getAcc_date() {
		return acc_date;
	}



	public void setAcc_date(String acc_date) {
		this.acc_date = acc_date;
	}
	

	public MyCustomer getCustomer() {
		return c1;
	}



	public void setCustomer(MyCustomer c1) {
		this.c1 = c1;
	}



	@Override
	public String toString() {
		return "Bankaccount [acc_num=" + acc_num + ", acc_type=" + acc_type + ", acc_bal=" + acc_bal + ", acc_date="
				+ acc_date + ", c1=" + c1 + "]";
	}
	
	
	

	
}
