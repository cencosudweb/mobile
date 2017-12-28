
/**
 *@name TipoOrdenServicesImpl.java
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

import com.cencosud.mobile.dao.TipoOrdenDao;
import com.cencosud.mobile.dao.domain.TipoOrden;
import com.cencosud.mobile.dto.users.TipoOrdenDTO;
import com.cencosud.mobile.core.TipoOrdenServices;
/**
 * @description   
 */
@Repository
public class TipoOrdenServicesImpl extends BaseServicesImpl implements TipoOrdenServices{

	@Autowired
	private TipoOrdenDao tipoOrdenDaoImpl;
	
	private static Logger log = Logger.getLogger(TipoOrdenServicesImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<TipoOrdenDTO> getTipoOrdens() {
		List<TipoOrdenDTO> result = new ArrayList<TipoOrdenDTO>();
		
		List<TipoOrden> tipoOrdens;
		try {
			
			tipoOrdens = tipoOrdenDaoImpl.getTipoOrdens();
			if(tipoOrdens != null && !tipoOrdens.isEmpty()){
				result = (List<TipoOrdenDTO>) mapper.map(tipoOrdens, List.class);
			}

		} catch (Exception e) {
			log.error("Error inesperado", e);
		}
		
		return result;
	}

	
}
