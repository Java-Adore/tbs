package com.tbs.managedbean;

import java.io.File;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.general.utils.Util;
import com.general.utils.WebUtils;
import com.tbs.business.service.MemberService;
import com.tbs.entity.Member;
import com.tbs.general.Constants;

@ManagedBean
@ApplicationScoped
public class HelperBean implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMemberImage(String str)
	{	
		try
		{
		if(Util.isNotEmpty(str)&& str instanceof String)
		{ 
			if( WebUtils.isFileExistInWar(Constants.STORE_FOLDER_NAME +"/"  +str) )
			{
			return Constants.STORE_FOLDER_NAME +"/"  +str ; 
			}else
			{
				throw Constants.EXCEPTION;

			}
			
		}else
		{ 
			throw Constants.EXCEPTION;
		} 
		}catch(Exception ex)
		{
			return Constants.STORE_FOLDER_NAME +"/" +Constants.DEFAULT_IMAGE_NAME;

		}
	}
	 
	public Member getCurrentMember()
	{
		return WebUtils.getCurrentUser();
	}
	
	
	public void validateCurrentUser()
	{
		WebUtils.validateCurrentUser();
	}

	public String getWetherIconsPath()
	{
		return "weathericons";
	}
	public String getWeatherIcon(String str)
	{	
		
		return Constants.ICONS_STORE_FOLDER_NAME +"/" +Constants.DEFAULT_IMAGE_NAME+str+".png";

	}

}
