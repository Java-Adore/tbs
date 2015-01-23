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
import com.tbs.business.facade.GetInfoFacade;
import com.tbs.business.facade.TourPackageFacade;
import com.tbs.entity.DomesticTraveller;
import com.tbs.entity.TourPackage;
import com.tbs.entity.TourSales;
import com.tbs.entity.Traveler;
import com.tbs.general.Constants;
import com.tbs.general.TBSException;

@ManagedBean
@ViewScoped
public class GetInfoBean implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	@EJB
	GetInfoFacade getInfoFacade;
	
	
	private List<TourPackage> tourPackages;
	
	private List<Traveler> travellers;
	
	@PostConstruct
	public void init(){
		
		try{
			tourPackages = getInfoFacade.getAllTourPackages();
			travellers = getInfoFacade.getAllTravelers();
			
		} catch (TBSException e) {

			WebUtils.fireErrorMessage(e.getMessageKey());
		}
	}
	
	
	public List<TourPackage> getTourPackages() {
	
		return tourPackages;
		
	}

	public void setTourPackages(List<TourPackage> tourPackages) {
		this.tourPackages = tourPackages;
	}

	public List<Traveler> getTravellers() {
		
		return travellers;
	}

	public void setTravellers(List<Traveler> travellers) {
		this.travellers = travellers;
	}
	

	public void getInfo(){
		
	}
	
	public void resetAttributes(){
		
	}
}
