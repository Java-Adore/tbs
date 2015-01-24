package com.tbs.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.general.utils.WebUtils;
import com.tbs.business.manage.Manageable;
import com.tbs.entity.TourPackage;
import com.tbs.entity.Traveler;
import com.tbs.general.Constants;
import com.tbs.general.TBSException;

@ManagedBean
@ViewScoped
public class TourSalesDetailsBean implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@EJB
	Manageable manage;
	
	private List<TourPackage> tourPackages;
	
	private List<Traveler> travelers;
	
	
	private Long selectedTourPackageID;
	private Long selectedTravelerID;
	
	public List<TourPackage> getTourPackages() {

		try {
			
			tourPackages = manage.getAllTourPackages();
			
		} catch (TBSException e) {

			WebUtils.fireErrorMessage(e.getMessageKey());
		}
		
		return tourPackages;
	}


	public List<Traveler> getTravelers() {
		
		try {
			
			travelers = manage.getAllTravelers();
			
		} catch (TBSException e) {

			WebUtils.fireErrorMessage(e.getMessageKey());
		}
		
		return travelers;
	}


	public Long getSelectedTourPackageID() {
		return selectedTourPackageID;
	}


	public void setSelectedTourPackageID(Long selectedTourPackageID) {
		this.selectedTourPackageID = selectedTourPackageID;
	}


	public Long getSelectedTravelerID() {
		return selectedTravelerID;
	}


	public void setSelectedTravelerID(Long selectedTravelerID) {
		this.selectedTravelerID = selectedTravelerID;
	}


	public void addNewTourSalesDetails(){
		
		
		try {
			if(tourPackages.size()==0 && travelers.size()==0)
			{
				WebUtils.fireInfoMessage(Constants.TOUR_SALES_NO_DATA_FOUND);
			}
			else if(selectedTourPackageID==null && selectedTravelerID==null){
				WebUtils.fireInfoMessage(Constants.TOUR_SALES_PLEASE_SELECT_DATA);
			}
			else{
				manage.addTourSales(selectedTourPackageID, selectedTravelerID);
				WebUtils.fireInfoMessage(Constants.TOUR_SALES_ADDED_SUCCESSFULLY);
			}
			
			
			
		} catch (TBSException e) {

			WebUtils.fireErrorMessage(e.getMessageKey());
		}
	}
	
}
