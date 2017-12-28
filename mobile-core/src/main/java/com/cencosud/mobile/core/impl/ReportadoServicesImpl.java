
/**
 *@name ReportadoServicesImpl.java
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

import com.cencosud.mobile.dao.ReportadoDao;
import com.cencosud.mobile.dao.domain.Reportado;
import com.cencosud.mobile.dto.users.ReportadoDTO;
import com.cencosud.mobile.core.ReportadoServices;
/**
 * @description 
 */
@Repository
public class ReportadoServicesImpl extends BaseServicesImpl implements ReportadoServices{

	@Autowired
	private ReportadoDao reportadoDaoImpl;
	
	private static Logger log = Logger.getLogger(ReportadoServicesImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<ReportadoDTO> getReportados() {
		List<ReportadoDTO> result = new ArrayList<ReportadoDTO>();
		
		List<Reportado> padrinos;
		try {
			
			padrinos = reportadoDaoImpl.getReportados();
			if(padrinos != null && !padrinos.isEmpty()){
				result = (List<ReportadoDTO>) mapper.map(padrinos, List.class);
			}

		} catch (Exception e) {
			log.error("Error inesperado", e);
		}
		
		return result;
	}

	
}
