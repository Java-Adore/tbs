package com.tbs.managedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

 


@ManagedBean
@ViewScoped
public class TestBean implements Serializable {


	
	public void execute()  { 
		try{
		

		System.out.println("===========================");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	
}
