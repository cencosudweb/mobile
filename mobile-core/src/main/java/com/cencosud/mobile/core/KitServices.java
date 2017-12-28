/**
 * @name KitServices.java
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

import com.cencosud.mobile.dto.ws.UrlNotificationParams;
import com.cencosud.mobile.dto.ws.UrlNotificationResult;
/**
 * @description   
 */
public interface KitServices {
	
	public UrlNotificationResult getUrlNotificacion(UrlNotificationParams params);
	
}
