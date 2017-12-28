
/**
 *@name EconomicActivityServicesImpl.java
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

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cencosud.mobile.core.EconomicActivityServices;
import com.cencosud.mobile.dao.EconomicActivityDao;
import com.cencosud.mobile.dao.domain.EconomicActivity;
import com.cencosud.mobile.dto.users.EconomicActivityDTO;

/**
 * @description   
 */
@Repository
public class EconomicActivityServicesImpl extends BaseServicesImpl implements EconomicActivityServices {

	@Autowired
	private EconomicActivityDao economicActivityDaoImpl;
	
	private static Logger log = Logger.getLogger(EconomicActivityServicesImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<EconomicActivityDTO> getActivities() {
		List<EconomicActivityDTO> result = new ArrayList<EconomicActivityDTO>();
		List<EconomicActivity> economicActivity;
		try {

			economicActivity = economicActivityDaoImpl.getActivities();
			result = (List<EconomicActivityDTO>) mapper.map(economicActivity, List.class);

		} catch (Exception e) {
			log.error("Error inesperado", e);
		}

		return result;
	}


}
