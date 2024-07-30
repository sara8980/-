package javaproject.demo.model;


import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "advertisement")
@Entity
@Data
public class TimeAdvertisement extends Advertisement implements Serializable{
	
	public TimeAdvertisement() {
		// TODO Auto-generated constructor stub
	}
	@Column
	private int minutes;
	
	
	
	

}
