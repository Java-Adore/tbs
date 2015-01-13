package com.tbs.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tbs.general.Marker;


@Entity
@Table(name="tour_sales")
public class TourSales implements Marker, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ID;
	
	@ManyToOne
	@JoinColumn(name="tour_package_id", referencedColumnName="ID")
	private TourPackage tourPackage;
	
	@ManyToOne
	@JoinColumn(name="traveller_id", referencedColumnName="ID")
	private Traveller traveller;
	
	
	public TourSales(){
		
	}
	public TourSales(TourPackage tourPackage, Traveller traveller) {
		this.setTourPackage(tourPackage);
		this.setTraveller(traveller);
	}

	@Override
	public Long getID() {
		return ID;
	}

	@Override
	public void setID(Long ID) {
		this.ID=ID;

	}

	public TourPackage getTourPackage() {
		return tourPackage;
	}

	public void setTourPackage(TourPackage tourPackage) {
		this.tourPackage = tourPackage;
	}

	public Traveller getTraveller() {
		return traveller;
	}

	public void setTraveller(Traveller traveller) {
		this.traveller = traveller;
	}
	
	

}
