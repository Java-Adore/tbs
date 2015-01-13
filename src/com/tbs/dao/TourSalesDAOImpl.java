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
import com.tbs.entity.TourSales;
import com.tbs.entity.Traveller;
import com.tbs.general.Constants;
import com.tbs.general.TBSException;

@Singleton
public class TourSalesDAOImpl extends AbstractDAO<TourSales> implements TourSalesDAO{

	EntityManager entityManager = getEntityManagerFactory()
			.createEntityManager();

	public TourSalesDAOImpl() {
		super.setEntityManager(entityManager);
	}

	@Override
	public TourSales addNewTourSales(TourSales tourSales) throws TBSException {
		
		return super.persist(tourSales);
	}

	@Override
	public List<TourSales> getAllTourSales() throws TBSException{
		EntityTransaction transaction = getEntityManager().getTransaction();
		List<TourSales> result = null;
		try {
			if (transaction.isActive() == false) {
				transaction.begin();
			}
			Query query = getEntityManager().createQuery("from TourSales t");
			
			result = query.getResultList();
			transaction.commit();
			
		}catch(Exception ex){
			transaction.rollback();
			ex.printStackTrace();
			throw Constants.TBS_RUNTIME_EXCEPTION;
		}
		
		return result;
	}

	
}
