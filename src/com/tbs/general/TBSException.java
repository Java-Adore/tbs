package com.tbs.general;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TBSException extends Exception  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messageKey;
	private Map feedBack = new HashMap();
	
	public TBSException(String messageKey) {
		this.messageKey = messageKey;
	}

	public TBSException() {
		// TODO Auto-generated constructor stub
	}

	public String getMessageKey() {
		return messageKey;
	}

	public TBSException setMessageKey(String messageKey) {
		this.messageKey = messageKey;
		return this;
	}

	public Map getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(Map feedBack) {
		this.feedBack = feedBack;
	}

	
	
}
