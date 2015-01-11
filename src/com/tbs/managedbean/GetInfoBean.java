package com.tbs.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.general.utils.WebUtils;
import com.tbs.business.facade.TourPackageFacade;
import com.tbs.entity.DomesticTraveller;
import com.tbs.entity.TourPackage;
import com.tbs.entity.Traveller;
import com.tbs.general.Constants;
import com.tbs.general.TBSException;

@ManagedBean
@ViewScoped
public class GetInfoBean implements Serializable {
	
	/**
	 * 
	 */
	
	TourPackage tp1 = new TourPackage("t1","v1",new Date(), "dep1", "des1");
	TourPackage tp2 = new TourPackage("t2","v2",new Date(), "dep2", "des2");
	TourPackage tp3 = new TourPackage("t3","v3",new Date(), "dep3", "des3");
	TourPackage tp4 = new TourPackage("t4","v4",new Date(), "dep4", "des4");
	TourPackage tp5 = new TourPackage("t5","v5",new Date(), "dep5", "des5");
	
	Traveller tr1 = new DomesticTraveller("f1","l1","ra1","ct1","ea1","pit1","pii1","pin1");
	Traveller tr2 = new DomesticTraveller("f2","l2","ra2","ct2","ea2","pit2","pii2","pin2");
	Traveller tr3 = new DomesticTraveller("f3","l3","ra3","ct3","ea3","pit3","pii3","pin3");
	Traveller tr4 = new DomesticTraveller("f4","l4","ra4","ct4","ea4","pit4","pii4","pin4");
	Traveller tr5 = new DomesticTraveller("f5","l5","ra5","ct5","ea5","pit5","pii5","pin5");
	
	private static final long serialVersionUID = 1L;

	@EJB
	TourPackageFacade tourPackageFacade;
	
	private List<TourPackage> tourPackages;
	
	private List<Traveller> travellers;
	
	
	private List<TourPackage> filteredPackages;
	
	private List<Traveller> filteredTravellers;
	
	
	public List<TourPackage> getTourPackages() {
		tourPackages = new ArrayList();
		tourPackages.add(tp1);
		tourPackages.add(tp2);
		tourPackages.add(tp3);
		tourPackages.add(tp4);
		tourPackages.add(tp5);
		
		return tourPackages;
	}

	public void setTourPackages(List<TourPackage> tourPackages) {
		this.tourPackages = tourPackages;
	}

	public List<Traveller> getTravellers() {
		travellers = new ArrayList();
		travellers.add(tr1);
		travellers.add(tr2);
		travellers.add(tr3);
		travellers.add(tr4);
		travellers.add(tr5);
		
		return travellers;
	}

	public void setTravellers(List<Traveller> travellers) {
		this.travellers = travellers;
	}
	
	public List<TourPackage> getFilteredPackages() {
		return filteredPackages;
	}

	public void setFilteredPackages(List<TourPackage> filteredPackages) {
		this.filteredPackages = filteredPackages;
	}

	public List<Traveller> getFilteredTravellers() {
		return filteredTravellers;
	}

	public void setFilteredTravellers(List<Traveller> filteredTravellers) {
		this.filteredTravellers = filteredTravellers;
	}

	public void getInfo(){
		
//		TourPackage tpResult = selectedTourPackage;
//		Traveller trResult = selectedTraveller;
		
//		try {
//			
//			TourPackage tourPackage = tourPackageFacade.addNewTourPackage(tourCode, vehicleNumberPlate, tourDate, departFrom, destination);
//			resetAttributes();
//			WebUtils.fireInfoMessage(Constants.TOUR_PACKAGE_ADDED_SUCCESSFULLY);
//			
//		} catch (TBSException e) {
//
//			WebUtils.fireErrorMessage(e.getMessageKey());
//		}
	}
	
	public void resetAttributes(){
		
	}
}
