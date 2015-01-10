package com.tbs.business.service;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.Local;
import javax.persistence.Column;

import com.tbs.entity.TourPackage;
import com.tbs.general.TBSException;

@Local
public interface TourPackageSrvice extends Serializable{

	public TourPackage addNewTourPackage(TourPackage tourPackage) throws TBSException;

}
