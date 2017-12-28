
/**
 *@name HorarioTrazabilidadActualizacionDao.java
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

import com.cencosud.mobile.dao.HorarioTrazabilidadActualizacionDao;
import com.cencosud.mobile.dao.domain.HorarioTrazabilidadActualizacion;
import com.cencosud.mobile.dto.users.HorarioTrazabilidadActualizacionDTO;
import com.cencosud.mobile.core.HorarioTrazabilidadActualizacionServices;
/**
 * @description 
 */
@Repository
public class HorarioTrazabilidadActualizacionServicesImpl extends BaseServicesImpl implements HorarioTrazabilidadActualizacionServices{

	@Autowired
	private HorarioTrazabilidadActualizacionDao horarioTrazabilidadActualizacionDaoImpl;
	
	private static Logger log = Logger.getLogger(HorarioTrazabilidadActualizacionServicesImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<HorarioTrazabilidadActualizacionDTO> getHorarioTrazabilidadActualizacions(int start, int limit) {
		List<HorarioTrazabilidadActualizacionDTO> result = new ArrayList<HorarioTrazabilidadActualizacionDTO>();
		
		List<HorarioTrazabilidadActualizacion> horarios;
		try {
			
			horarios = horarioTrazabilidadActualizacionDaoImpl.getHorarioTrazabilidadActualizacions(start, limit);
			if(horarios != null && !horarios.isEmpty()){
				result = (List<HorarioTrazabilidadActualizacionDTO>) mapper.map(horarios, List.class);
			}

		} catch (Exception e) {
			log.error("Error inesperado", e);
		}
		
		return result;
	}

	

	
}
