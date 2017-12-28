
/**
 *@name PrioridadServicesImpl.java
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

import com.cencosud.mobile.dao.PrioridadDao;
import com.cencosud.mobile.dao.domain.Prioridad;
import com.cencosud.mobile.dto.users.PrioridadDTO;
import com.cencosud.mobile.core.PrioridadServices;
/**
 * @description 
 */
@Repository
public class PrioridadServicesImpl extends BaseServicesImpl implements PrioridadServices{

	@Autowired
	private PrioridadDao prioridadDaoImpl;
	
	private static Logger log = Logger.getLogger(PrioridadServicesImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<PrioridadDTO> getPrioridads() {
		List<PrioridadDTO> result = new ArrayList<PrioridadDTO>();
		
		List<Prioridad> padrinos;
		try {
			
			padrinos = prioridadDaoImpl.getPrioridads();
			if(padrinos != null && !padrinos.isEmpty()){
				result = (List<PrioridadDTO>) mapper.map(padrinos, List.class);
			}

		} catch (Exception e) {
			log.error("Error inesperado", e);
		}
		
		return result;
	}

	
}
