package com.tbs.business.service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tbs.dao.TourPackageDAO;
import com.tbs.dao.TourSalesDAO;
import com.tbs.dao.TravellerDAO;
import com.tbs.entity.DomesticTraveller;
import com.tbs.entity.InternationalTraveller;
import com.tbs.entity.TourPackage;
import com.tbs.entity.TourSales;
import com.tbs.entity.Traveller;
import com.tbs.general.*;

@Stateless
public class GetInfoServiceImpl implements GetInfoService {

	private static final long serialVersionUID = 1L;
	
	
	@EJB
	TourSalesDAO tourSalesDAO;


	@Override
	public List<TourSales> getAllTourSales() throws TBSException {
		
		return tourSalesDAO.getAllTourSales();
	}


	
	
}
