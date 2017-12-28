
/**
 *@name HorarioVentaEnVerdeActualizacionServicesImpl.java
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

import com.cencosud.mobile.dao.HorarioVentaEnVerdeActualizacionDao;
import com.cencosud.mobile.dao.domain.HorarioVentaEnVerdeActualizacion;
import com.cencosud.mobile.dto.users.HorarioVentaEnVerdeActualizacionDTO;
import com.cencosud.mobile.core.HorarioVentaEnVerdeActualizacionServices;
/**
 * @description 
 */
@Repository
public class HorarioVentaEnVerdeActualizacionServicesImpl extends BaseServicesImpl implements HorarioVentaEnVerdeActualizacionServices{

	@Autowired
	private HorarioVentaEnVerdeActualizacionDao horarioVentaEnVerdeActualizacionDaoImpl;
	
	private static Logger log = Logger.getLogger(HorarioVentaEnVerdeActualizacionServicesImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<HorarioVentaEnVerdeActualizacionDTO> getHorarioVentaEnVerdeActualizacions(int start, int limit) {
		List<HorarioVentaEnVerdeActualizacionDTO> result = new ArrayList<HorarioVentaEnVerdeActualizacionDTO>();
		
		List<HorarioVentaEnVerdeActualizacion> horarios;
		try {
			
			horarios = horarioVentaEnVerdeActualizacionDaoImpl.getHorarioVentaEnVerdeActualizacions(start, limit);
			if(horarios != null && !horarios.isEmpty()){
				result = (List<HorarioVentaEnVerdeActualizacionDTO>) mapper.map(horarios, List.class);
			}

		} catch (Exception e) {
			log.error("Error inesperado", e);
		}
		
		return result;
	}

	

	
}
