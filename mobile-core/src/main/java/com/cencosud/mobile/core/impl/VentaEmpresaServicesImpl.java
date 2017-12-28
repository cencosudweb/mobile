
/**
 *@name VentaEmpresaServicesImpl.java
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

import com.cencosud.mobile.dao.VentaEmpresaDao;
import com.cencosud.mobile.dao.domain.VentaEmpresa;
import com.cencosud.mobile.dto.users.VentaEmpresaDTO;
import com.cencosud.mobile.core.VentaEmpresaServices;
/**
 * @description   
 */
@Repository
public class VentaEmpresaServicesImpl extends BaseServicesImpl implements VentaEmpresaServices{

	@Autowired
	private VentaEmpresaDao ventaEmpresaDaoImpl;
	
	private static Logger log = Logger.getLogger(VentaEmpresaServicesImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<VentaEmpresaDTO> getVentaEmpresas() {
		List<VentaEmpresaDTO> result = new ArrayList<VentaEmpresaDTO>();
		
		List<VentaEmpresa> ventaEmpresas;
		try {
			
			ventaEmpresas =ventaEmpresaDaoImpl.getVentaEmpresas();
			if(ventaEmpresas != null && !ventaEmpresas.isEmpty()){
				result = (List<VentaEmpresaDTO>) mapper.map(ventaEmpresas, List.class);
			}

		} catch (Exception e) {
			log.error("Error inesperado", e);
		}
		
		return result;
	}

	
}
