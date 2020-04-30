package com.spangular.spangular.database.dynamodb.repositories;

import java.util.List;

import com.spangular.spangular.database.dynamodb.models.Customer;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
@EnableScan
@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {
 
  List<Customer> findByLastName(String lastName);
}