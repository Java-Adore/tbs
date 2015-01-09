package com.tbs.business.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tbs.dao.MemberDAO;
import com.tbs.entity.Member;
import com.tbs.general.Constants;
import com.tbs.general.TBSException;

@Stateless
public class MemberServiceImpl implements MemberService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	MemberDAO memberDAO;

	
	public Member addMember(Member member) throws TBSException {
		try {
			if (getMemeberByEmail(member.getEmail()) == null) {
				return memberDAO.addMember(member);
			} else {
				throw Constants.EMAIL_ALREADY_EXISTS;

			}
		} catch (TBSException ex) {
			throw ex;
		} catch (Exception ex) {
			throw Constants.DATABASE_ERROR;

		}
	}

	
	public List<Member> getAllMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Member getMemberByID(Long l) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Member login(String email, String password) throws TBSException {

		Member member = getMemeberByEmail(email);
		if (member == null) {
			throw Constants.invalidEmail;
		} else {
			if (member.getPassword() != null
					&& member.getPassword().equals(password)) {
				return member;

			} else {
				throw Constants.invalidPassword;
			}
		}
	}

	private Member getMemeberByEmail(String email) {
		return memberDAO.getMemeberByEmail(email);
	}

	
	public Member register(String firstName, String lastName, String email,
			String password, String confirmPassword, String userPicPath)
			throws TBSException {
	
		
		Member member = new Member();
		member.setEmail(email);
		member.setFirstName(firstName);
		member.setLastName(lastName);
		member.setUserPicPath(userPicPath);
		member.setPassword(password);

		member = addMember(member);
		return member;

	}
	
	

}
