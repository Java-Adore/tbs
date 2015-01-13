package com.tbs.business.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tbs.business.service.GetInfoService;
import com.tbs.business.service.TourPackageService;
import com.tbs.entity.TourPackage;
import com.tbs.entity.TourSales;
import com.tbs.general.TBSException;

@Stateless
public class GetInfoFacadeImpl implements GetInfoFacade {

	@EJB
	GetInfoService getInfoService;

	@Override
	public List<TourSales> getAllTourSales() throws TBSException {
		// TODO Auto-generated method stub
		return getInfoService.getAllTourSales();
	}
	


}
