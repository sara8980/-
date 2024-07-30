package javaproject.demo.dto;

import java.util.Date;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AdvertisementDTO {
    private int code;
	private int areaCode;
	private boolean active;
	private int customerCode;
	private Date orderDate;
	private byte [] file;
	
}
