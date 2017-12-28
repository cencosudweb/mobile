
/**
 *@name EstadoCumpleResumenServicesImpl.java
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

import com.cencosud.mobile.dao.EstadoCumpleResumenDao;
import com.cencosud.mobile.dao.domain.EstadoCumpleResumen;
import com.cencosud.mobile.dto.users.EstadoCumpleResumenDTO;
import com.cencosud.mobile.core.EstadoCumpleResumenServices;
/**
 * @description   
 */
@Repository
public class EstadoCumpleResumenServicesImpl extends BaseServicesImpl implements EstadoCumpleResumenServices{

	@Autowired
	private EstadoCumpleResumenDao estadoCumpleResumenDaoImpl;
	
	private static Logger log = Logger.getLogger(EstadoCumpleResumenServicesImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<EstadoCumpleResumenDTO> getEstadoCumpleResumens() {
		// TODO Auto-generated method stub
		List<EstadoCumpleResumenDTO> result = new ArrayList<EstadoCumpleResumenDTO>();
		
		List<EstadoCumpleResumen> estados;
		try {
			
			estados = estadoCumpleResumenDaoImpl.getEstadoCumpleResumens();
			if(estados != null && !estados.isEmpty()){
				result = (List<EstadoCumpleResumenDTO>) mapper.map(estados, List.class);
			}

		} catch (Exception e) {
			log.error("Error inesperado", e);
		}
		
		return result;
	}


	
	
	
}
