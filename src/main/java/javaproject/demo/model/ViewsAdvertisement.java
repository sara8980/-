package javaproject.demo.model;


import jakarta.persistence.*;
import lombok.Data;

@Table(name = "advertisement")
@Entity
@Data
public class ViewsAdvertisement extends Advertisement {
	
	public ViewsAdvertisement() {
		// TODO Auto-generated constructor stub
	}
	@Column
	private int wantedViews;
	@Column
	private int amountViews;
	

}
