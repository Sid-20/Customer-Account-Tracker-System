package com.wipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.Repo.BankaccountRepo;
import com.wipro.entities.Bankaccount;




@Service
public class BankaccountServiceImp implements BankaccountService {
	
	@Autowired
	private BankaccountRepo arepo;
	
	public BankaccountServiceImp(BankaccountRepo arepo)
	{
		this.arepo=arepo;
	}

	@Override
	public Bankaccount addAccount(Bankaccount a1) {
		this.arepo.save(a1);
		System.out.println("The Record is added to the database");
		return a1;
	}

	@Override
	public List<Bankaccount> getAllAccounts() {
		List<Bankaccount> b1=(List<Bankaccount>) this.arepo.findAll();
		return b1;
	}

	@Override
	public Bankaccount deleteAccount(String acc_num) {
		Bankaccount b1=this.arepo.findById(acc_num).get();
		this.arepo.deleteById(acc_num);
		System.out.println("The Account is deleted");
		return b1;
	}

	@Override
	public Bankaccount getAccount(String acc_num) {
		Bankaccount b1=this.arepo.findById(acc_num).get();
		System.out.println("The Account details are: "+b1);
		return b1;
	}

	@Override
	public Bankaccount updateAccount(Bankaccount b1) {
		this.arepo.save(b1);
		System.out.println("Bank Account Updated");
		return b1;
	}



}
