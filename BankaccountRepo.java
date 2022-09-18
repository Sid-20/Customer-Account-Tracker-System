package com.wipro.Repo;


import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wipro.entities.Bankaccount;





@Repository
@Transactional
public interface BankaccountRepo extends CrudRepository<Bankaccount,String> {

}
