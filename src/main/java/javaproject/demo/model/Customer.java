package javaproject.demo.model;


import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
	@Column
	private String idNumber;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String password;	
	
	@OneToMany(mappedBy = "customer_")
	private Set<Advertisement> advs;
	
	public Set<Advertisement> getAdvs() {
		return advs;
	}
	
	// public void setAdvs(Set<Advertisement> advs) {
	// 	this.advs = advs;
	// }


	// public int getCode() {
	// 	return code;
	// }

	// public void setCode(int code) {
	// 	this.code = code;
	// }

	// public String getIdNumber() {
	// 	return idNumber;
	// }

	// public void setIdNumber(String idNumber) {
	// 	this.idNumber = idNumber;
	// }

	// public String getName() {
	// 	return name;
	// }

	// public void setName(String name) {
	// 	this.name = name;
	// }

	// public String getEmail() {
	// 	return email;
	// }

	// public void setEmail(String email) {
	// 	this.email = email;
	// }

	// public String getPassword() {
	// 	return password;
	// }

	// public void setPassword(String password) {
	// 	this.password = password;
	// }

	
}
