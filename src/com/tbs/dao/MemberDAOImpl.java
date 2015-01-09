package com.tbs.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transaction;

import org.hibernate.CacheMode;

import com.general.utils.Util;
import com.tbs.entity.Member;

@Singleton
public class MemberDAOImpl extends AbstractDAO<Member> implements MemberDAO {

	EntityManager entityManager = getEntityManagerFactory()
			.createEntityManager();

	public MemberDAOImpl() {
		super.setEntityManager(entityManager);
	}

	public Member addMember(Member Member) {

		return super.persist(Member);
	}

	public List<Member> getAllMembers() {
		// TODO Auto-generated method stub
		return super.findAll(Member.class);
	}

	public Member getMemberByID(Long ID) {
		return super.getEntityByID(Member.class, ID);
	}

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

	
}
