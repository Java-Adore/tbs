package com.tbs.managedbean;

import java.io.Serializable;
import java.util.Date;
import java.util.Hashtable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Column;

import com.general.utils.WebUtils;
import com.tbs.business.facade.TourPackageFacade;
import com.tbs.entity.TourPackage;
import com.tbs.general.Constants;
import com.tbs.general.TBSException;

@ManagedBean
@ViewScoped
public class TravellerBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	TourPackageFacade tourPackageFacade;

	private String firstName;

	private String lastName;
	
	private String residentialAddress;
	
	private String contactTelephone;

	private String emailAddress;
	
	//for domestic traveller
	private String photoIdentificationType;
	
	private String photoIdentificationIssuer;
	
	private String photoIdentificationNumber;

	//for international traveller
	private String passportNumber;
	
	private String passportCountry;
	
	private String visaNumber;
	
	private boolean domesticFlag;
	private boolean internationalFlag;
	
	private String travellerType="domestic";
	
	@PostConstruct
	public void init(){
		domesticFlag=true;
		internationalFlag=false;
	}

	public TourPackageFacade getTourPackageFacade() {
		return tourPackageFacade;
	}

	public void setTourPackageFacade(TourPackageFacade tourPackageFacade) {
		this.tourPackageFacade = tourPackageFacade;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getResidentialAddress() {
		return residentialAddress;
	}

	public void setResidentialAddress(String residentialAddress) {
		this.residentialAddress = residentialAddress;
	}

	public String getContactTelephone() {
		return contactTelephone;
	}

	public void setContactTelephone(String contactTelephone) {
		this.contactTelephone = contactTelephone;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhotoIdentificationType() {
		return photoIdentificationType;
	}

	public void setPhotoIdentificationType(String photoIdentificationType) {
		this.photoIdentificationType = photoIdentificationType;
	}

	public String getPhotoIdentificationIssuer() {
		return photoIdentificationIssuer;
	}

	public void setPhotoIdentificationIssuer(String photoIdentificationIssuer) {
		this.photoIdentificationIssuer = photoIdentificationIssuer;
	}

	public String getPhotoIdentificationNumber() {
		return photoIdentificationNumber;
	}

	public void setPhotoIdentificationNumber(String photoIdentificationNumber) {
		this.photoIdentificationNumber = photoIdentificationNumber;
	}

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
	

	public String getTravellerType() {
		return travellerType;
	}

	public void setTravellerType(String travellerType) {
		if(travellerType.equals("domestic")){
			this.domesticFlag=true;
			this.internationalFlag=false;
		}
		else if(travellerType.equals("international")){
			this.domesticFlag=false;
			this.internationalFlag=true;
		}
		this.travellerType = travellerType;
	}
	

	public boolean isDomesticFlag() {
		return domesticFlag;
	}

	public boolean isInternationalFlag() {
		return internationalFlag;
	}

	public void addNewTraveller(){
		/*
		try {
			
			TourPackage tourPackage = tourPackageFacade.addNewTourPackage(tourCode, vehicleNumberPlate, tourDate, departFrom, destination);
			resetAttributes();
			WebUtils.fireInfoMessage(Constants.TOUR_PACKAGE_ADDED_SUCCESSFULLY);
			
		} catch (TBSException e) {

			WebUtils.fireErrorMessage(e.getMessageKey());
		}*/
	}
	
	public void resetAttributes(){
		
	}
}
