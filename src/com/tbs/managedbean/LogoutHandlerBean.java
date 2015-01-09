package com.tbs.managedbean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

import com.general.utils.WebUtils;
import com.tbs.general.Constants;

@ManagedBean
@ApplicationScoped
public class LogoutHandlerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */


	public void logout()
	{
		WebUtils.invalidateSession();
		WebUtils.redirectTo("login.xhtml");
	}

}
