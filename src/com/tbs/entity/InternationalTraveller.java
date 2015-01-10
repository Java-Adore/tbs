package com.tbs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.tbs.general.Marker;

@Entity
@Table(name="international_travellers")
public class InternationalTraveller extends Traveller implements Serializable,Marker{
	
	private static final long serialVersionUID = 1L;

	@Column(name="passport_number")
	private String passportNumber;
	
	@Column(name="passport_country")
	private String passportCountry;
	
	@Column(name="visa_number")
	private String visaNumber;

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPassportCountry() {
		return passportCountry;
	}

	public void setPassportCountry(String passportCountry) {
		this.passportCountry = passportCountry;
	}

	public String getVisaNumber() {
		return visaNumber;
	}

	public void setVisaNumber(String visaNumber) {
		this.visaNumber = visaNumber;
	}
	
	
}
