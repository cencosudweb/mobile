/**
 *@name HorarioVentaEnVerdeActualizacionDao.java
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

import com.cencosud.mobile.dao.domain.HorarioVentaEnVerdeActualizacion;
/**
 * @description Interface  
 */
public interface HorarioVentaEnVerdeActualizacionDao {

	public List<HorarioVentaEnVerdeActualizacion> getHorarioVentaEnVerdeActualizacions(int start, int limit);
	
}
