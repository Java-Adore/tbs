package com.tbs.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.general.utils.Util;
import com.tbs.entity.TourPackage;
import com.tbs.general.TBSException;

public class TourPackageDAOImpl extends AbstractDAO<TourPackage> implements TourPackageDAO{

	EntityManager entityManager = getEntityManagerFactory()
			.createEntityManager();

	public TourPackageDAOImpl() {
		super.setEntityManager(entityManager);
	}

	@Override
	public TourPackage addTourPackage(TourPackage tourPackage){

		return super.persist(tourPackage);
	}

	@Override
	public List<TourPackage> getAllTourPackages(){
		
		EntityTransaction transaction = getEntityManager().getTransaction();
		List<TourPackage> result = new ArrayList();
		try {
			if (transaction.isActive() == false) {
				transaction.begin();
			}
			Query query = getEntityManager().createQuery("from TourPackage t");
			
			result = query.getResultList();
			transaction.commit();
			
		}catch(Exception ex){
			transaction.rollback();
			ex.printStackTrace();
		}
		
		return result;
		
	}
	
	
}
