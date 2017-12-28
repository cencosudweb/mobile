
/**
 *@name CuadraturaOrdenCompraVentaCompServicesImpl.java
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

import com.cencosud.mobile.dao.CuadraturaOrdenCompraVentaCompDao;
import com.cencosud.mobile.dao.domain.CuadraturaOrdenCompraVentaComp;
import com.cencosud.mobile.dto.users.CuadraturaOrdenCompraVentaCompDTO;
import com.cencosud.mobile.core.CuadraturaOrdenCompraVentaCompServices;
/**
 * @description 
 */
@Repository
public class CuadraturaOrdenCompraVentaCompServicesImpl extends BaseServicesImpl implements CuadraturaOrdenCompraVentaCompServices{

	@Autowired
	private CuadraturaOrdenCompraVentaCompDao cuadraturaOrdenCompraVentaCompDaoImpl;
	
	private static Logger log = Logger.getLogger(CuadraturaOrdenCompraVentaCompServicesImpl.class);

	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<CuadraturaOrdenCompraVentaCompDTO> getCuadraturaOrdenCompraVentaComps(String starttime) {
		// TODO Auto-generated method stub
		List<CuadraturaOrdenCompraVentaCompDTO> result = new ArrayList<CuadraturaOrdenCompraVentaCompDTO>();
		
		List<CuadraturaOrdenCompraVentaComp> cuadraturaOrdenCompraVentaComps;
		try {
			
			cuadraturaOrdenCompraVentaComps = cuadraturaOrdenCompraVentaCompDaoImpl.getCuadraturaOrdenCompraVentaComps(starttime);
			if(cuadraturaOrdenCompraVentaComps != null && !cuadraturaOrdenCompraVentaComps.isEmpty()){
				result = (List<CuadraturaOrdenCompraVentaCompDTO>) mapper.map(cuadraturaOrdenCompraVentaComps, List.class);
			}

		} catch (Exception e) {
			log.error("Error inesperado", e);
		}
		
		return result;
	}
	
	
	
}
