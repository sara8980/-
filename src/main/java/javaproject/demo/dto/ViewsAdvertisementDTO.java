package javaproject.demo.dto;

import jakarta.persistence.Column;
import lombok.Data;
@Data
public class ViewsAdvertisementDTO extends AdvertisementDTO{

	private int wantedViews;
	private int amountViews;
}
