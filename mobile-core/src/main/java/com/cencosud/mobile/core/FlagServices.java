/**
 *@name FlagServices.java
 * 
 *@version 1.0 
 * 
 *@date 07-03-2017
 * 
 *@author EA7129
 * 
 *@copyright Cencosud. All rights reserved.
 */
package com.cencosud.mobile.core;

import java.util.List;

import com.cencosud.mobile.dto.users.FlagDTO;
/**
 * @description   
 */
public interface FlagServices {

	public List<FlagDTO> getFlags();
	
}
