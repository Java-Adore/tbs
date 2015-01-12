package com.tbs.business.facade;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tbs.business.service.TourPackageService;
import com.tbs.entity.TourPackage;
import com.tbs.general.TBSException;

@Stateless
public class TourPackageFacadeImpl implements TourPackageFacade {

	@EJB
	TourPackageService tourPackageSrvice;
	
	@Override
	public TourPackage addNewTourPackage(String tourCode,
			String vehicleNumberPlate, Date tourDate, String departFrom,
			String detination) throws TBSException {
		
		TourPackage tourPackage = new TourPackage(tourCode, vehicleNumberPlate, tourDate, departFrom, detination);
				
		return tourPackageSrvice.addNewTourPackage(tourPackage);
	}

}
