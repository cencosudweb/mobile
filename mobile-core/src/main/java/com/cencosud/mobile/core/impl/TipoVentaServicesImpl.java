
/**
 *@name TipoVentaServicesImpl.java
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

import com.cencosud.mobile.dao.TipoVentaDao;
import com.cencosud.mobile.dao.domain.TipoVenta;
import com.cencosud.mobile.dto.users.TipoVentaDTO;
import com.cencosud.mobile.core.TipoVentaServices;
/**
 * @description   
 */
@Repository
public class TipoVentaServicesImpl extends BaseServicesImpl implements TipoVentaServices{

	@Autowired
	private TipoVentaDao tipoVentaDaoImpl;
	
	private static Logger log = Logger.getLogger(TipoVentaServicesImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<TipoVentaDTO> getTipoVentas() {
		List<TipoVentaDTO> result = new ArrayList<TipoVentaDTO>();
		
		List<TipoVenta> tipoVentas;
		try {
			
			tipoVentas = tipoVentaDaoImpl.getTipoVentas();
			if(tipoVentas != null && !tipoVentas.isEmpty()){
				result = (List<TipoVentaDTO>) mapper.map(tipoVentas, List.class);
			}

		} catch (Exception e) {
			log.error("Error inesperado", e);
		}
		
		return result;
	}

	
}
