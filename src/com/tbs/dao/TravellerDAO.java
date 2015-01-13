package com.tbs.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import com.tbs.entity.DomesticTraveller;
import com.tbs.entity.InternationalTraveller;
import com.tbs.entity.Traveller;
import com.tbs.general.TBSException;


@Local
public interface TravellerDAO extends Serializable{
	
	public Traveller addTraveller(Traveller traveller);
	
	public Traveller addDomesticTraveller(DomesticTraveller domesticTraveller) throws TBSException;
	
	public Traveller addInternationalTraveller(InternationalTraveller internationalTraveller) throws TBSException;
	
	public List<Traveller> getAllTravellers() throws TBSException;

	public Traveller getTravellerByID(Long travellerID) throws TBSException;
}
