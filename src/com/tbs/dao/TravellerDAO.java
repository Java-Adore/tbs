package com.tbs.dao;

import javax.ejb.Local;

import com.tbs.entity.Traveller;


@Local
public interface TravellerDAO {
	
	public Traveller addTraveller(Traveller traveller);
}
