
/**
 *@name AreaServicesImpl.java
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

import com.cencosud.mobile.dao.AreaDao;
import com.cencosud.mobile.dao.domain.Area;
import com.cencosud.mobile.dto.users.AreaDTO;
import com.cencosud.mobile.core.AreaServices;
/**
 * @description 
 */
@Repository
public class AreaServicesImpl extends BaseServicesImpl implements AreaServices{

	@Autowired
	private AreaDao areaDaoImpl;
	
	private static Logger log = Logger.getLogger(AreaServicesImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<AreaDTO> getAreas() {
		List<AreaDTO> result = new ArrayList<AreaDTO>();
		
		List<Area> areas;
		try {
			
			areas = areaDaoImpl.getAreas();
			if(areas != null && !areas.isEmpty()){
				result = (List<AreaDTO>) mapper.map(areas, List.class);
			}

		} catch (Exception e) {
			log.error("Error inesperado", e);
		}
		
		return result;
	}

	
}
