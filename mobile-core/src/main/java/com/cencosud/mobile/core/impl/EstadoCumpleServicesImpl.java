
/**
 *@name EstadoCumpleServicesImpl.java
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

import com.cencosud.mobile.dao.EstadoCumpleDao;
import com.cencosud.mobile.dao.domain.EstadoCumple;
import com.cencosud.mobile.dto.users.EstadoCumpleDTO;
import com.cencosud.mobile.core.EstadoCumpleServices;
/**
 * @description   
 */
@Repository
public class EstadoCumpleServicesImpl extends BaseServicesImpl implements EstadoCumpleServices{

	@Autowired
	private EstadoCumpleDao estadoCumpleDaoImpl;
	
	private static Logger log = Logger.getLogger(EstadoCumpleServicesImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<EstadoCumpleDTO> getEstadoCumples() {
		// TODO Auto-generated method stub
		List<EstadoCumpleDTO> result = new ArrayList<EstadoCumpleDTO>();
		
		List<EstadoCumple> estados;
		try {
			
			estados = estadoCumpleDaoImpl.getEstadoCumples();
			if(estados != null && !estados.isEmpty()){
				result = (List<EstadoCumpleDTO>) mapper.map(estados, List.class);
			}

		} catch (Exception e) {
			log.error("Error inesperado", e);
		}
		
		return result;
	}
	
	

	
	
	
}
