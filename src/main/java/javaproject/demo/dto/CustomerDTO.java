package javaproject.demo.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CustomerDTO {
    private int code;
	private String idNumber;
	private String name;
	private String email;
	private String password;	
    
}
