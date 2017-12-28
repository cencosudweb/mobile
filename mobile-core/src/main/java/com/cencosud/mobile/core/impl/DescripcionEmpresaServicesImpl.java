
/**
 *@name DescripcionEmpresaServicesImpl.java
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

import com.cencosud.mobile.dao.DescripcionEmpresaDao;
import com.cencosud.mobile.dao.domain.DescripcionEmpresa;
import com.cencosud.mobile.dto.users.DescripcionEmpresaDTO;
import com.cencosud.mobile.core.DescripcionEmpresaServices;
/**
 * @description   
 */
@Repository
public class DescripcionEmpresaServicesImpl extends BaseServicesImpl implements DescripcionEmpresaServices{

	@Autowired
	private DescripcionEmpresaDao DescripcionEmpresaDaoImpl;
	
	private static Logger log = Logger.getLogger(DescripcionEmpresaServicesImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DescripcionEmpresaDTO> getDescripcionEmpresas() {
		List<DescripcionEmpresaDTO> result = new ArrayList<DescripcionEmpresaDTO>();
		
		List<DescripcionEmpresa> descripcionEmpresas;
		try {
			
			descripcionEmpresas = DescripcionEmpresaDaoImpl.getDescripcionEmpresas();
			if(descripcionEmpresas != null && !descripcionEmpresas.isEmpty()){
				result = (List<DescripcionEmpresaDTO>) mapper.map(descripcionEmpresas, List.class);
			}

		} catch (Exception e) {
			log.error("Error inesperado", e);
		}
		
		return result;
	}

	
}
