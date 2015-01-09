package com.tbs.managedbean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.general.utils.WebUtils;
import com.tbs.business.service.MemberService;
import com.tbs.entity.Member;
import com.tbs.general.Constants;
import com.tbs.general.TBSException;



@ManagedBean
@ViewScoped
public class LoginBean implements Serializable{

	/**
	 * 
	 */
	// Construct alert thread bean 

	@EJB 
	MemberService memberService;
	
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String password;
	
	@PostConstruct
	public void init(){
		
		
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void login(){
		try {
			System.out.println("===========================\n\n\n========================");
			Member member = 	memberService.login(email , password);
			WebUtils.fireInfoMessage( WebUtils.perpareWelcomeMessage(member.getFirstName()) );
			
			WebUtils.injectIntoSession( Constants.CURRENT_LOGGED_USER , member );
				
			WebUtils.redirectTo(Constants.HOME_PAGE);
			
		} catch (TBSException e) {
			WebUtils.fireErrorMessage(e.getMessageKey());
		}
		
	}
}
