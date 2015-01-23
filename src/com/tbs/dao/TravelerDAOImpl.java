package com.tbs.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.tbs.entity.DomesticTraveller;
import com.tbs.entity.InternationalTraveller;
import com.tbs.entity.TourPackage;
import com.tbs.entity.Traveler;
import com.tbs.general.Constants;
import com.tbs.general.TBSException;

@Singleton
public class TravelerDAOImpl extends AbstractDAO<Traveler> implements TravelerDAO{

	EntityManager entityManager = getEntityManagerFactory()
			.createEntityManager();

	public TravelerDAOImpl() {
		super.setEntityManager(entityManager);
	}

	@Override
	public Traveler addTraveller(Traveler traveller) {

		return super.persist(traveller);
	}

	@Override
	public Traveler addDomesticTraveller(DomesticTraveller domesticTraveller) {
		return super.persist(domesticTraveller);
	}

	@Override
	public Traveler addInternationalTraveller(InternationalTraveller internationalTraveller) {
		return super.persist(internationalTraveller);
	}

	@Override
	public List<Traveler> getAllTravellers() throws TBSException {
		EntityTransaction transaction = getEntityManager().getTransaction();
		List<Traveler> result = null;
		try {
			if (transaction.isActive() == false) {
				transaction.begin();
			}
			Query query = getEntityManager().createQuery("from Traveler t");
			
			result = query.getResultList();
			transaction.commit();
			
		}catch(Exception ex){
			transaction.rollback();
			ex.printStackTrace();
			throw Constants.TBS_RUNTIME_EXCEPTION;
		}
		
		return result;
	}

	@Override
	public Traveler getTravellerByID(Long travellerID) throws TBSException {
		
		EntityTransaction transaction = getEntityManager().getTransaction();
		List<Traveler> queryResult = new ArrayList();
		Traveler traveller = null;
		
		try {
			if (transaction.isActive() == false) {
				transaction.begin();
			}
			Query query = getEntityManager().createQuery("from Traveler t where t.ID=:travellerID");
			query.setParameter("travellerID", travellerID);
			
			queryResult = query.getResultList();
			if(queryResult.size()>0)
			{
				traveller = queryResult.get(0);
			}
			
			transaction.commit();
			
		}catch(Exception ex){
			transaction.rollback();
			ex.printStackTrace();
			throw Constants.TBS_RUNTIME_EXCEPTION;
		}
		
		return traveller;
	}
	
}
