/**
 * @name EconomicActivityServices.java
 * 
 * @version 1.0
 * 
 * @date 13/11/2016
 * 
 * @author josef_000
 * 
 * @copyright 
 * 
 */
package com.cencosud.mobile.core;

import java.util.List;

import com.cencosud.mobile.dto.users.EconomicActivityDTO;
/**
 * @description Interface  
 */

public interface EconomicActivityServices {

	public List<EconomicActivityDTO> getActivities();
	
}
