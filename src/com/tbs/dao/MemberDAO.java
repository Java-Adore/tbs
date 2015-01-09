package com.tbs.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import com.tbs.entity.Member;

@Local
public interface MemberDAO extends Serializable{

	/**
	 * 
	 */
	
	Member addMember(Member Member);

	List<Member> getAllMembers();

	Member getMemberByID(Long l);

	Member getMemeberByEmail(String email);
	
	
	 

}
