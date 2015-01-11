package com.tbs.dao;


import javax.ejb.Singleton;
import javax.persistence.EntityManager;

import com.tbs.entity.DomesticTraveller;

@Singleton
public class DomesticTravellerDAOImpl extends AbstractDAO<DomesticTraveller> implements DomesticTravellerDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	EntityManager entityManager = getEntityManagerFactory()
			.createEntityManager();

	public DomesticTravellerDAOImpl() {
		super.setEntityManager(entityManager);
	}


	@Override
	public DomesticTraveller addDomesticTraveller(DomesticTraveller domesticTraveller) {
		return super.persist(domesticTraveller);
	}

}
