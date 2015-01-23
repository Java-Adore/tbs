package com.tbs.business.facade;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tbs.business.service.TourPackageService;
import com.tbs.business.service.TourSalesService;
import com.tbs.business.service.TravelerService;
import com.tbs.entity.TourPackage;
import com.tbs.entity.TourSales;
import com.tbs.entity.Traveler;
import com.tbs.general.TBSException;

@Stateless
public class TourSalesFacadeImpl implements TourSalesFacade {

	@EJB
	TourSalesService tourSalesService;

	@Override
	public List<Traveler> getAllTravellers() throws TBSException {
		return tourSalesService.getAllTravellers();
	}

	@Override
	public List<TourPackage> getAllTourPackages() throws TBSException {
		// TODO Auto-generated method stub
		return tourSalesService.getAllTourPackages();
	}

	@Override
	public TourSales addTourSales(Long selectedTourPackage,
			Long selectedTraveller) throws TBSException{
		
		return tourSalesService.addTourSales(selectedTourPackage, selectedTraveller);
	}

}
