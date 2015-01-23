package com.tbs.business.facade;

import java.io.Serializable;

import javax.ejb.Local;

import com.tbs.entity.DomesticTraveller;
import com.tbs.entity.InternationalTraveller;
import com.tbs.entity.Traveler;
import com.tbs.general.TBSException;

@Local
public interface TravelerFacade extends Serializable{

	public DomesticTraveller addDomesticTraveller(String firstName, String lastName, String residentialAddress,
			String contactTelephone, String emailAddress, String photoIdentificationType,
			String photoIdentificationIssuer, String photoIdentificationNumber) throws TBSException;
	
	public InternationalTraveller addInternationalTraveller(String firstName, String lastName, String residentialAddress,
			String contactTelephone, String emailAddress, String passportNumber,
			String passportCountry, String visaNumber) throws TBSException;
}
