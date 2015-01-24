package com.tbs.business.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.persistence.Column;

import com.tbs.entity.DomesticTraveler;
import com.tbs.entity.InternationalTraveler;
import com.tbs.entity.TourPackage;
import com.tbs.entity.TourSales;
import com.tbs.entity.Traveler;
import com.tbs.general.TBSException;

@Local
public interface GetInfoService extends Serializable{
	public List<TourSales> getAllTourSales() throws TBSException;
	public List<TourPackage> getAllTourPackages() throws TBSException;
	public List<Traveler> getAllTravelers() throws TBSException;
}
