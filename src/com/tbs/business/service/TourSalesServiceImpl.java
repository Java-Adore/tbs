package com.tbs.business.service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tbs.dao.TourPackageDAO;
import com.tbs.dao.TourSalesDAO;
import com.tbs.dao.TravelerDAO;
import com.tbs.entity.DomesticTraveller;
import com.tbs.entity.InternationalTraveller;
import com.tbs.entity.TourPackage;
import com.tbs.entity.TourSales;
import com.tbs.entity.Traveler;
import com.tbs.general.*;

@Stateless
public class TourSalesServiceImpl implements TourSalesService {

	private static final long serialVersionUID = 1L;
	
	@EJB
	TravelerDAO travellerDAO;

	@EJB
	TourPackageDAO tourPackageDAO;
	
	@EJB
	TourSalesDAO tourSalesDAO;

	@Override
	public List<TourPackage> getAllTourPackages() throws TBSException {
		
		return tourPackageDAO.getAllTourPackages();
	}

	@Override
	public List<Traveler> getAllTravellers() throws TBSException {
		
		return travellerDAO.getAllTravellers();
	}

	@Override
	public TourSales addTourSales(Long tourPackageID,
			Long travellerID) throws TBSException{
		
		
		TourSales tourSales = new TourSales(tourPackageDAO.getTourPackageByID(tourPackageID), travellerDAO.getTravellerByID(travellerID));
		
		return tourSalesDAO.addNewTourSales(tourSales);
	}
	
	
	
	
}
