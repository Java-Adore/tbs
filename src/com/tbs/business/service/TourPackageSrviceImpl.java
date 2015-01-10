package com.tbs.business.service;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tbs.dao.TourPackageDAO;
import com.tbs.entity.TourPackage;
import com.tbs.general.*;

@Stateless
public class TourPackageSrviceImpl implements TourPackageSrvice {

	private static final long serialVersionUID = 1L;
	
	@EJB
	TourPackageDAO tourPackageDAO;
	
	@Override
	public TourPackage addNewTourPackage(TourPackage tourPackage){
		
		return tourPackageDAO.addTourPackage(tourPackage);
	}
}
