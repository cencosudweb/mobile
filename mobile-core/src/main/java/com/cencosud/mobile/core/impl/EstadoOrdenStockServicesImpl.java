
/**
 *@name EstadoOrdenStockServicesImpl.java
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

import com.cencosud.mobile.dao.EstadoOrdenStockDao;
import com.cencosud.mobile.dao.domain.EstadoOrdenStock;
import com.cencosud.mobile.dto.users.EstadoOrdenStockDTO;
import com.cencosud.mobile.core.EstadoOrdenStockServices;
/**
 * @description   
 */
@Repository
public class EstadoOrdenStockServicesImpl extends BaseServicesImpl implements EstadoOrdenStockServices{

	@Autowired
	private EstadoOrdenStockDao estadoOrdenStockDaoImpl;
	
	private static Logger log = Logger.getLogger(EstadoOrdenStockServicesImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<EstadoOrdenStockDTO> getEstadoOrdenStocks() {
		List<EstadoOrdenStockDTO> result = new ArrayList<EstadoOrdenStockDTO>();
		
		List<EstadoOrdenStock> ordenes;
		try {
			
			ordenes = estadoOrdenStockDaoImpl.getEstadoOrdenStocks();
			if(ordenes != null && !ordenes.isEmpty()){
				result = (List<EstadoOrdenStockDTO>) mapper.map(ordenes, List.class);
			}

		} catch (Exception e) {
			log.error("Error inesperado", e);
		}
		
		return result;
	}

	
}
