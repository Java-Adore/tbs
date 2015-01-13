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
import com.tbs.entity.Traveller;
import com.tbs.general.Constants;
import com.tbs.general.TBSException;

@Singleton
public class TravellerDAOImpl extends AbstractDAO<Traveller> implements TravellerDAO{

	EntityManager entityManager = getEntityManagerFactory()
			.createEntityManager();

	public TravellerDAOImpl() {
		super.setEntityManager(entityManager);
	}

	@Override
	public Traveller addTraveller(Traveller traveller) {

		return super.persist(traveller);
	}

	@Override
	public Traveller addDomesticTraveller(DomesticTraveller domesticTraveller) {
		return super.persist(domesticTraveller);
	}

	@Override
	public Traveller addInternationalTraveller(InternationalTraveller internationalTraveller) {
		return super.persist(internationalTraveller);
	}

	@Override
	public List<Traveller> getAllTravellers() throws TBSException {
		EntityTransaction transaction = getEntityManager().getTransaction();
		List<Traveller> result = null;
		try {
			if (transaction.isActive() == false) {
				transaction.begin();
			}
			Query query = getEntityManager().createQuery("from Traveller t");
			
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
	public Traveller getTravellerByID(Long travellerID) throws TBSException {
		
		EntityTransaction transaction = getEntityManager().getTransaction();
		List<Traveller> queryResult = new ArrayList();
		Traveller traveller = null;
		
		try {
			if (transaction.isActive() == false) {
				transaction.begin();
			}
			Query query = getEntityManager().createQuery("from Traveller t where t.ID=:travellerID");
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
	
	/*
	 public Member getMemeberByEmail(String email) {
		EntityTransaction transaction = getEntityManager().getTransaction();
		List<Member> result = new ArrayList();
		try {
			if (transaction.isActive() == false) {
				transaction.begin();
			}
			Query query = getEntityManager().createQuery(
					"from Member where lower(email) like :email");
			query.setParameter("email", email.toLowerCase());
			result = query.getResultList();
			Util.isNotEmpty(result);
			return Util.isNotEmpty(result) ? result.get(0) : null;
		} finally {
			transaction.commit();
		}

	}
	 * */
}
