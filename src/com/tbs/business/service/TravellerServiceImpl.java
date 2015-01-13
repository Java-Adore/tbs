package com.tbs.business.service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tbs.dao.TourPackageDAO;
import com.tbs.dao.TravellerDAO;
import com.tbs.entity.DomesticTraveller;
import com.tbs.entity.InternationalTraveller;
import com.tbs.entity.TourPackage;
import com.tbs.entity.Traveller;
import com.tbs.general.*;

@Stateless
public class TravellerServiceImpl implements TravellerService {

	private static final long serialVersionUID = 1L;
	
	@EJB
	TravellerDAO travellerDAO;

	@Override
	public Traveller addDomesticTraveller(DomesticTraveller domesticTraveller)
			throws TBSException {
		
		return travellerDAO.addDomesticTraveller(domesticTraveller);
	}

	@Override
	public Traveller addInternationalTraveller(
			InternationalTraveller internationalTraveller) throws TBSException {
		
		return travellerDAO.addInternationalTraveller(internationalTraveller);
	}

	@Override
	public List<Traveller> getAllTravellers() throws TBSException {
		
		return travellerDAO.getAllTravellers();
	}
	
	
}
