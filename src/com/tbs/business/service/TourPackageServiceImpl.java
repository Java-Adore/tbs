package com.tbs.business.service;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tbs.dao.TourPackageDAO;
import com.tbs.entity.TourPackage;
import com.tbs.general.*;

@Stateless
public class TourPackageServiceImpl implements TourPackageService {

	private static final long serialVersionUID = 1L;
	
	@EJB
	TourPackageDAO tourPackageDAO;
	
	@Override
	public TourPackage addNewTourPackage(TourPackage tourPackage) throws TBSException{
		if(tourPackageDAO.getTourPackage(tourPackage)==null)
			return tourPackageDAO.addTourPackage(tourPackage);
		else
			throw Constants.DUPLICATED_TOUR_CODE_ERROR;
	}
}
