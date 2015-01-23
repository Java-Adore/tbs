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
	
	private List<Traveler> travellers;
	
	
	private Long selectedTourPackageID;
	private Long selectedTravellerID;
	
	public List<TourPackage> getTourPackages() {

		try {
			
			tourPackages = manage.getAllTourPackages();
			
		} catch (TBSException e) {

			WebUtils.fireErrorMessage(e.getMessageKey());
		}
		
		return tourPackages;
	}


	public List<Traveler> getTravellers() {
		
		try {
			
			travellers = manage.getAllTravellers();
			
		} catch (TBSException e) {

			WebUtils.fireErrorMessage(e.getMessageKey());
		}
		
		return travellers;
	}


	public Long getSelectedTourPackageID() {
		return selectedTourPackageID;
	}


	public void setSelectedTourPackageID(Long selectedTourPackageID) {
		this.selectedTourPackageID = selectedTourPackageID;
	}


	public Long getSelectedTravellerID() {
		return selectedTravellerID;
	}


	public void setSelectedTravellerID(Long selectedTravellerID) {
		this.selectedTravellerID = selectedTravellerID;
	}


	public void addNewTourSalesDetails(){
		
		
		try {
			if(tourPackages.size()==0 && travellers.size()==0)
			{
				WebUtils.fireInfoMessage(Constants.TOUR_SALES_NO_DATA_FOUND);
			}
			else if(selectedTourPackageID==null && selectedTravellerID==null){
				WebUtils.fireInfoMessage(Constants.TOUR_SALES_PLEASE_SELECT_DATA);
			}
			else{
				manage.addTourSales(selectedTourPackageID, selectedTravellerID);
				WebUtils.fireInfoMessage(Constants.TOUR_SALES_ADDED_SUCCESSFULLY);
			}
			
			
			
		} catch (TBSException e) {

			WebUtils.fireErrorMessage(e.getMessageKey());
		}
	}
	
}
