
/**
 *@name HorarioServicesImpl.java
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

import com.cencosud.mobile.dao.HorarioDao;
import com.cencosud.mobile.dao.domain.Horario;
import com.cencosud.mobile.dto.users.HorarioDTO;
import com.cencosud.mobile.core.HorarioServices;
/**
 * @description   
 */
@Repository
public class HorarioServicesImpl extends BaseServicesImpl implements HorarioServices{

	@Autowired
	private HorarioDao horarioDaoImpl;
	
	private static Logger log = Logger.getLogger(HorarioServicesImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<HorarioDTO> getHorarios() {
		List<HorarioDTO> result = new ArrayList<HorarioDTO>();
		
		List<Horario> horarios;
		try {
			
			horarios = horarioDaoImpl.getHorarios();
			if(horarios != null && !horarios.isEmpty()){
				result = (List<HorarioDTO>) mapper.map(horarios, List.class);
			}

		} catch (Exception e) {
			log.error("Error inesperado", e);
		}
		
		return result;
	}

	
}
