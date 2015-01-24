package com.tbs.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.general.utils.WebUtils;
import com.tbs.business.manage.Manageable;
import com.tbs.entity.TourPackage;
import com.tbs.entity.Traveler;
import com.tbs.general.TBSException;

@ManagedBean
@ViewScoped
public class GetInfoBean implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	Manageable manage;
	
	
	private List<TourPackage> tourPackages;
	
	private List<Traveler> travelers;
	
	@PostConstruct
	public void init(){
		
		try{
			tourPackages = manage.getAllTourPackages();
			travelers = manage.getAllTravelers();
			
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

	public List<Traveler> getTravelers() {
		
		return travelers;
	}

	public void setTravelers(List<Traveler> travelers) {
		this.travelers = travelers;
	}
	

	public void getInfo(){
		
	}
	
	public void resetAttributes(){
		
	}
}
