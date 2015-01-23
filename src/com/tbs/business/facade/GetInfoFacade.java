package com.tbs.business.facade;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import com.tbs.entity.DomesticTraveller;
import com.tbs.entity.InternationalTraveller;
import com.tbs.entity.TourPackage;
import com.tbs.entity.TourSales;
import com.tbs.entity.Traveler;
import com.tbs.general.TBSException;

@Local
public interface GetInfoFacade extends Serializable{

	public List<TourSales> getAllTourSales() throws TBSException;
	public List<TourPackage> getAllTourPackages() throws TBSException;
	public List<Traveler> getAllTravelers() throws TBSException;
	
}
