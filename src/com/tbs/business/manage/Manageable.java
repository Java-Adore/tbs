package com.tbs.business.manage;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.tbs.entity.DomesticTraveller;
import com.tbs.entity.InternationalTraveller;
import com.tbs.entity.TourPackage;
import com.tbs.entity.TourSales;
import com.tbs.entity.Traveler;
import com.tbs.general.TBSException;

@Local
public interface Manageable extends Serializable{
	
	//Common Methods
	public List<TourPackage> getAllTourPackages() throws TBSException;
	
	//GetInformation methods
	public List<TourSales> getAllTourSales() throws TBSException;
	
	public List<Traveler> getAllTravelers() throws TBSException;
	
	//TourPackage methods
	public TourPackage addNewTourPackage(String tourCode, String vehicleNumberPlate, Date tourDate, String departFrom, String detination) throws TBSException;
	
	//TourSales methods
	public List<Traveler> getAllTravellers() throws TBSException;

	public TourSales addTourSales(Long selectedTourPackage, Long selectedTraveller) throws TBSException;
	
	//Traveller methods
	public DomesticTraveller addDomesticTraveller(String firstName, String lastName, String residentialAddress,
			String contactTelephone, String emailAddress, String photoIdentificationType,
			String photoIdentificationIssuer, String photoIdentificationNumber) throws TBSException;
	
	public InternationalTraveller addInternationalTraveller(String firstName, String lastName, String residentialAddress,
			String contactTelephone, String emailAddress, String passportNumber,
			String passportCountry, String visaNumber) throws TBSException;
}
