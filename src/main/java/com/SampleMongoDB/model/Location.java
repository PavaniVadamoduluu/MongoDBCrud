package com.SampleMongoDB.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "location")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

	@Id
	private String id;
	
    @NotEmpty (message = "Address is mandatory")
	private String address;

    @NotEmpty(message = "City is mandatory")
	private String city;
	
    @NotEmpty(message = "State is mandatory")
	private String state;
	
    @NotEmpty(message = "Country is mandatory")
	private String country;

    @NotNull(message = "Zipcode is mandatory")
	@Min(6)
    @Digits(integer=6, fraction=2)
    private int zipcode;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	
}
