package javaproject.demo.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javaproject.demo.dto.CustomerDTO;
import javaproject.demo.model.Customer;

public interface CustomerService {
    
 
public CustomerDTO getByEmailAndPassword( String email, String password);

}
