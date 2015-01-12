package com.tbs.business.service;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.Local;
import javax.persistence.Column;

import com.tbs.entity.DomesticTraveller;
import com.tbs.entity.InternationalTraveller;
import com.tbs.entity.TourPackage;
import com.tbs.entity.Traveller;
import com.tbs.general.TBSException;

@Local
public interface TravellerService extends Serializable{

	public Traveller addDomesticTraveller(DomesticTraveller domesticTraveller) throws TBSException;
	
	public Traveller addInternationalTraveller(InternationalTraveller internationalTraveller) throws TBSException;

}
