package com.tbs.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.tbs.entity.Traveller;

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
