/**
 *@name MobileMailSender.java
 * 
 *@version 1.0 
 * 
 *@date 07-03-2017
 * 
 *@author EA7129
 * 
 *@copyright Cencosud. All rights reserved.
 */
package com.cencosud.mobile.core.enums;

/**
 * @description   
 */
public enum LogEnum {
	
	LOG_USERLOGGED(1),                       
	LOG_USERCREDENCIALEXPIRE(2),
	LOG_USERACCOUNTBLOCKED(3),
	LOG_USERPASSWORDINVALID(4),
	LOG_USERNOTEXIST(5);
	
	private final int code;
	
	LogEnum(int code) {
		this.code = code;
	}
	
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

}
