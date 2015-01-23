package com.tbs.business.service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tbs.dao.TourPackageDAO;
import com.tbs.dao.TravelerDAO;
import com.tbs.entity.DomesticTraveller;
import com.tbs.entity.InternationalTraveller;
import com.tbs.entity.TourPackage;
import com.tbs.entity.Traveler;
import com.tbs.general.*;

@Stateless
public class TravelerServiceImpl implements TravelerService {

	private static final long serialVersionUID = 1L;
	
	@EJB
	TravelerDAO travellerDAO;

	@Override
	public Traveler addDomesticTraveller(DomesticTraveller domesticTraveller)
			throws TBSException {
		
		return travellerDAO.addDomesticTraveller(domesticTraveller);
	}

	@Override
	public Traveler addInternationalTraveller(
			InternationalTraveller internationalTraveller) throws TBSException {
		
		return travellerDAO.addInternationalTraveller(internationalTraveller);
	}

	@Override
	public List<Traveler> getAllTravellers() throws TBSException {
		
		return travellerDAO.getAllTravellers();
	}
	
	
}
