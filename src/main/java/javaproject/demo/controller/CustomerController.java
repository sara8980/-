package javaproject.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javaproject.demo.dal.CustomerReposirory;
import javaproject.demo.dto.CustomerDTO;
import javaproject.demo.model.Customer;
import javaproject.demo.service.CustomerService;
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customer;

    @GetMapping("/login")
    public CustomerDTO getByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
        return customer.getByEmailAndPassword(email, password);
    }

}
