package com.tbs.dao;


import javax.ejb.Singleton;
import javax.persistence.EntityManager;

import com.tbs.entity.DomesticTraveller;
import com.tbs.entity.InternationalTraveller;

@Singleton
public class InternationalTravellerDAOImpl extends AbstractDAO<InternationalTraveller> implements InternationalTravellerDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	EntityManager entityManager = getEntityManagerFactory()
			.createEntityManager();

	public InternationalTravellerDAOImpl() {
		super.setEntityManager(entityManager);
	}

	@Override
	public InternationalTraveller addInternationalTraveller(
			InternationalTraveller internationalTraveller) {
		return super.persist(internationalTraveller);
	}



}
