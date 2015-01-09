package com.tbs.business.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import com.tbs.entity.Member;
import com.tbs.general.TBSException;

@Local
public interface MemberService extends Serializable{

	/**
	 * 
	 */
	
	Member addMember(Member Member) throws TBSException;

	List<Member> getAllMembers();

	Member getMemberByID(Long l);
	
	Member login(String email , String password)throws TBSException ;
	
	Member register(String firstName, String lastName, String email, String password, String confirmPassword, String pictureURL) throws TBSException ;
	

	
}
