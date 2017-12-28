
/**
 *@name KitServicesImpl.java
 * 
 *@version 1.0 
 * 
 *@date 07-03-2017
 * 
 *@author EA7129
 * 
 *@copyright Cencosud. All rights reserved.
 */
package com.cencosud.mobile.core.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cencosud.mobile.core.KitServices;
import com.cencosud.mobile.dao.domain.UrlCallback;
import com.cencosud.mobile.dao.mapper.KitMapper;
import com.cencosud.mobile.dto.users.UrlCallbackDTO;
import com.cencosud.mobile.dto.ws.UrlNotificationParams;
import com.cencosud.mobile.dto.ws.UrlNotificationResult;

/**
 * @description   
 */
@Repository
public class KitServicesImpl extends BaseServicesImpl implements KitServices {

	@Autowired
	private KitMapper kitDaoImpl;

	private static Logger log = Logger.getLogger(KitServicesImpl.class);

	@Override
	public UrlNotificationResult getUrlNotificacion(UrlNotificationParams params) {
		UrlCallbackDTO urlCallback = null;
		UrlNotificationResult result = new UrlNotificationResult();
		try {
			UrlCallback agreementSource = kitDaoImpl.getUrlCallback(params.getIdAgreement(), params.getChannel());
			if(agreementSource != null){
				urlCallback = mapper.map(agreementSource, UrlCallbackDTO.class);
			}
			
			result.setUrlCallback(urlCallback);
			
		} catch (Exception e) {
			log.error("Error inesperado", e);
			result.setCodError(100);
			result.setMsgError("Error inesperado");
		}
		return result;
	}
}
