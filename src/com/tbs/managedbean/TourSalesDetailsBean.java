package com.tbs.managedbean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.general.utils.WebUtils;
import com.tbs.business.facade.TourSalesFacade;
import com.tbs.entity.DomesticTraveller;
import com.tbs.entity.TourPackage;
import com.tbs.entity.Traveller;
import com.tbs.general.Constants;
import com.tbs.general.TBSException;

@ManagedBean
@ViewScoped
public class TourSalesDetailsBean implements Serializable {
	
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
	TourSalesFacade tourSalesFacade;
	
	private List<TourPackage> tourPackages;
	
	private List<Traveller> travellers;
	
	
	private Long selectedTourPackageID;
	private Long selectedTravellerID;
	
	public List<TourPackage> getTourPackages() {

		try {
			
			tourPackages = tourSalesFacade.getAllTourPackages();
			
		} catch (TBSException e) {

			WebUtils.fireErrorMessage(e.getMessageKey());
		}
		
		return tourPackages;
	}


	public List<Traveller> getTravellers() {
		
		try {
			
			travellers = tourSalesFacade.getAllTravellers();
			
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
				tourSalesFacade.addTourSales(selectedTourPackageID, selectedTravellerID);
				WebUtils.fireInfoMessage(Constants.TOUR_SALES_ADDED_SUCCESSFULLY);
			}
			
			
			
		} catch (TBSException e) {

			WebUtils.fireErrorMessage(e.getMessageKey());
		}
	}
	
}
