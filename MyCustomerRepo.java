package com.wipro.Repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wipro.entities.MyCustomer;

@Repository
@Transactional
public interface MyCustomerRepo extends CrudRepository<MyCustomer,String> {

}
