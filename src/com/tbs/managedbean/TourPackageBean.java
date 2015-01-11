package com.tbs.managedbean;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.general.utils.WebUtils;
import com.tbs.business.facade.TourPackageFacade;
import com.tbs.entity.TourPackage;
import com.tbs.general.Constants;
import com.tbs.general.TBSException;

@ManagedBean
@ViewScoped
public class TourPackageBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	TourPackageFacade tourPackageFacade;
	
	private String tourCode;
	
	private String vehicleNumberPlate;
	
	private Date tourDate;
	
	private String departFrom;
	
	private String destination;
	
	private Date today;
	
	@PostConstruct
	public void init(){
		today = new Date();
	}

	public String getTourCode() {
		return tourCode;
	}

	public void setTourCode(String tourCode) {
		this.tourCode = tourCode;
	}

	public String getVehicleNumberPlate() {
		return vehicleNumberPlate;
	}

	public void setVehicleNumberPlate(String vehicleNumberPlate) {
		this.vehicleNumberPlate = vehicleNumberPlate;
	}

	public Date getTourDate() {
		return tourDate;
	}

	public void setTourDate(Date tourDate) {
		this.tourDate = tourDate;
	}

	public String getDepartFrom() {
		return departFrom;
	}

	public void setDepartFrom(String departFrom) {
		this.departFrom = departFrom;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getToday() {
		return today;
	}

	public void addNewPackage(){
		try {
			
			TourPackage tourPackage = tourPackageFacade.addNewTourPackage(tourCode, vehicleNumberPlate, tourDate, departFrom, destination);
			resetAttributes();
			WebUtils.fireInfoMessage(Constants.TOUR_PACKAGE_ADDED_SUCCESSFULLY);
			
		} catch (TBSException e) {

			WebUtils.fireErrorMessage(e.getMessageKey());
		}
	}
	
	public void resetAttributes(){
		this.tourCode="";
		this.vehicleNumberPlate="";
		this.tourDate = new Date();
		this.departFrom="";
		this.destination="";
	}
}
