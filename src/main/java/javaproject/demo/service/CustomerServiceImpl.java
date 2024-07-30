package javaproject.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javaproject.demo.dal.CustomerReposirory;
import javaproject.demo.dto.CustomerDTO;
import javaproject.demo.model.Advertisement;
import javaproject.demo.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
  @Autowired
  private CustomerReposirory customerRep;
  @Autowired
  private ModelMapper mapper;

  public CustomerDTO getByEmailAndPassword(String email, String password) {
    try {
      Customer customerEmail = (Customer) customerRep.findByEmail(email);
      Customer customerpassword = (Customer) customerRep.findByPassword(password);
      if (customerEmail != null && customerpassword != null) {
        if (customerEmail.getPassword().equals(customerpassword.getPassword())
            && customerEmail.getEmail() .equals(customerpassword.getEmail()) ) {
          Customer c = customerEmail;
          CustomerDTO customerDto = mapper.map(c, CustomerDTO.class);
          return customerDto;
        }
      }

    } catch (Exception e) {
      throw new RuntimeException("the emil and password not exists!", e);
    }
    return null;

  }

}
