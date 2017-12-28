
/**
 *@name EstadoServicesImpl.java
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

import com.cencosud.mobile.dao.EstadoDao;
import com.cencosud.mobile.dao.domain.Estado;
import com.cencosud.mobile.dto.users.EstadoDTO;
import com.cencosud.mobile.core.EstadoServices;
/**
 * @description   
 */
@Repository
public class EstadoServicesImpl extends BaseServicesImpl implements EstadoServices{

	@Autowired
	private EstadoDao estadoDaoImpl;
	
	private static Logger log = Logger.getLogger(EstadoServicesImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<EstadoDTO> getEstados() {
		List<EstadoDTO> result = new ArrayList<EstadoDTO>();
		
		List<Estado> estados;
		try {
			
			estados = estadoDaoImpl.getEstados();
			if(estados != null && !estados.isEmpty()){
				result = (List<EstadoDTO>) mapper.map(estados, List.class);
			}

		} catch (Exception e) {
			log.error("Error inesperado", e);
		}
		
		return result;
	}

	@Override
	@Transactional
	public EstadoDTO getEstadosId(Long id) {
		// TODO Auto-generated method stub
		EstadoDTO estadoDestination = null;
		try {
			Estado estadoSource = estadoDaoImpl.getEstadosId(id);
			if(estadoSource!=null)
				estadoDestination = mapper.map(estadoSource, EstadoDTO.class);
		} catch (Exception e) {
			log.error("Error inesperado", e);
		}
		return estadoDestination;
	}

	
}
