package com.tbs.business.facade;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tbs.business.service.TravellerService;
import com.tbs.entity.DomesticTraveller;
import com.tbs.entity.InternationalTraveller;
import com.tbs.entity.TourPackage;
import com.tbs.general.Constants;
import com.tbs.general.TBSException;

@Stateless
public class TravellerFacadeImpl implements TravellerFacade {

	@EJB
	TravellerService travellerSrvice;

	@Override
	public DomesticTraveller addDomesticTraveller(String firstName,
			String lastName, String residentialAddress,
			String contactTelephone, String emailAddress,
			String photoIdentificationType, String photoIdentificationIssuer,
			String photoIdentificationNumber) throws TBSException {
		
		DomesticTraveller domesticTraveller = new DomesticTraveller(firstName, lastName, residentialAddress, contactTelephone, emailAddress, photoIdentificationType, photoIdentificationIssuer, photoIdentificationNumber);
		
		try {
			return (DomesticTraveller) travellerSrvice.addDomesticTraveller(domesticTraveller);
		} catch (Exception e) {

			throw Constants.TBS_TRAVELLER_CASTING_EXCEPTION;
		}
	}

	@Override
	public InternationalTraveller addInternationalTraveller(String firstName,
			String lastName, String residentialAddress,
			String contactTelephone, String emailAddress,
			String passportNumber, String passportCountry, String visaNumber) throws TBSException {
		
		InternationalTraveller internationalTraveller = new InternationalTraveller(firstName, lastName, residentialAddress, contactTelephone, emailAddress, passportNumber, passportCountry, visaNumber);
		try {
			return (InternationalTraveller) travellerSrvice.addInternationalTraveller(internationalTraveller);
		} catch (Exception e) {

			throw Constants.TBS_TRAVELLER_CASTING_EXCEPTION;
		}
	}
	
	

}
