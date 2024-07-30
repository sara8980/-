package javaproject.demo.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import javaproject.demo.model.Customer;

public interface CustomerReposirory  extends CrudRepository<Customer,Integer> { 

public Customer findByEmail(String email);

public Customer findByPassword(String password);

}
