package com.tbs.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import com.tbs.entity.DomesticTraveler;
import com.tbs.entity.InternationalTraveler;
import com.tbs.entity.Traveler;
import com.tbs.general.TBSException;


@Local
public interface TravelerDAO extends Serializable{
	
	public Traveler addTraveller(Traveler traveller);
	
	public Traveler addDomesticTraveller(DomesticTraveler domesticTraveller) throws TBSException;
	
	public Traveler addInternationalTraveller(InternationalTraveler internationalTraveller) throws TBSException;
	
	public List<Traveler> getAllTravellers() throws TBSException;

	public Traveler getTravellerByID(Long travellerID) throws TBSException;
}
