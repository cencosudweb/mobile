/**
 *@name HorarioTrazabilidadActualizacionServices.java
 * 
 *@version 1.0 
 * 
 *@date 07-03-2017
 * 
 *@author EA7129
 * 
 *@copyright Cencosud. All rights reserved.
 */
package com.cencosud.mobile.core;

import java.util.List;

import com.cencosud.mobile.dto.users.HorarioTrazabilidadActualizacionDTO;
/**
 * @description   
 */
public interface HorarioTrazabilidadActualizacionServices {

	public List<HorarioTrazabilidadActualizacionDTO> getHorarioTrazabilidadActualizacions(int start, int limit);
	
}
