package com.tbs.dao;

import java.util.List;

import com.tbs.entity.TourPackage;
import com.tbs.general.TBSException;

public interface TourPackageDAO {

	public TourPackage addTourPackage(TourPackage tourPackage);
	
	public List<TourPackage> getAllTourPackages();
}
