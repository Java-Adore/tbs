package com.tbs.dao;

import javax.ejb.Singleton;
import javax.ejb.Stateless;

@Singleton
public class GenericDAO extends AbstractDAO{
	
	
	public GenericDAO()
	{
		super.setEntityManager(entityManagerFactory.createEntityManager());
	}
	

}
