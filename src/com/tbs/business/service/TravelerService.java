package com.tbs.business.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.persistence.Column;

import com.tbs.entity.DomesticTraveler;
import com.tbs.entity.InternationalTraveler;
import com.tbs.entity.TourPackage;
import com.tbs.entity.Traveler;
import com.tbs.general.TBSException;

@Local
public interface TravelerService extends Serializable{

	public Traveler addDomesticTraveller(DomesticTraveler domesticTraveller) throws TBSException;
	
	public Traveler addInternationalTraveller(InternationalTraveler internationalTraveller) throws TBSException;

	public List<Traveler> getAllTravellers() throws TBSException;
}
