package com.tbs.business.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.persistence.Column;

import com.tbs.entity.DomesticTraveller;
import com.tbs.entity.InternationalTraveller;
import com.tbs.entity.TourPackage;
import com.tbs.entity.Traveler;
import com.tbs.general.TBSException;

@Local
public interface TravelerService extends Serializable{

	public Traveler addDomesticTraveller(DomesticTraveller domesticTraveller) throws TBSException;
	
	public Traveler addInternationalTraveller(InternationalTraveller internationalTraveller) throws TBSException;

	public List<Traveler> getAllTravellers() throws TBSException;
}
