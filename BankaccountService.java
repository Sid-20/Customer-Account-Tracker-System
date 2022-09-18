package com.wipro.service;

import java.util.List;

import com.wipro.entities.Bankaccount;





public interface BankaccountService {
	
	public Bankaccount addAccount(Bankaccount a1);
	public List<Bankaccount> getAllAccounts();
	public Bankaccount deleteAccount(String acc_num);
	public Bankaccount getAccount(String acc_num);
	public Bankaccount updateAccount(Bankaccount b1);
}
