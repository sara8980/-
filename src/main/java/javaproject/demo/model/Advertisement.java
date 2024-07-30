package javaproject.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.*;


import lombok.Data;

@Entity
@Table
@Data
public class Advertisement {
	
	public Advertisement() {
	
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
	
	@Column
	private int areaCode;
	
	@Column
	private boolean active;
	
	@Column
	private int customerCode;
	
	@Column
	private Date orderDate;
	
	
	@ManyToOne
	@JoinColumn(name = "areaCode",referencedColumnName = "code",insertable = false,updatable = false)
	private Area area_;
	
	@ManyToOne
	@JoinColumn(name = "customerCode",referencedColumnName = "code",insertable = false,updatable = false)
	private Customer customer_;
	
}