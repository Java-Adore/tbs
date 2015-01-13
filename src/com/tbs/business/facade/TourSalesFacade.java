package com.tbs.business.facade;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import com.tbs.entity.DomesticTraveller;
import com.tbs.entity.InternationalTraveller;
import com.tbs.entity.TourPackage;
import com.tbs.entity.TourSales;
import com.tbs.entity.Traveller;
import com.tbs.general.TBSException;

@Local
public interface TourSalesFacade extends Serializable{

	public List<Traveller> getAllTravellers() throws TBSException;
	
	public List<TourPackage> getAllTourPackages() throws TBSException;

	public TourSales addTourSales(Long selectedTourPackage, Long selectedTraveller) throws TBSException;
}
