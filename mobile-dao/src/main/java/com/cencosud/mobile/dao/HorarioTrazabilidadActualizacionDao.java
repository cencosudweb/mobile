/**
 *@name HorarioTrazabilidadActualizacionDao.java
 * 
 *@version 1.0 
 * 
 *@date 07-03-2017
 * 
 *@author EA7129
 * 
 *@copyright Cencosud. All rights reserved.
 */
package com.cencosud.mobile.dao;

import java.util.List;

import com.cencosud.mobile.dao.domain.HorarioTrazabilidadActualizacion;
/**
 * @description Interface  
 */
public interface HorarioTrazabilidadActualizacionDao {

	public List<HorarioTrazabilidadActualizacion> getHorarioTrazabilidadActualizacions(int start, int limit);
	
}
