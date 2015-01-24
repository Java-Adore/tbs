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
	
	public Traveler addTraveler(Traveler traveller);
	
	public Traveler addDomesticTraveller(DomesticTraveler domesticTraveller) throws TBSException;
	
	public Traveler addInternationalTraveler(InternationalTraveler internationalTraveller) throws TBSException;
	
	public List<Traveler> getAllTravelers() throws TBSException;

	public Traveler getTravelerByID(Long travellerID) throws TBSException;
}
