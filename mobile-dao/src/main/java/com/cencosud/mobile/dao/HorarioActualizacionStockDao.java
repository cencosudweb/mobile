/**
 *@name HorarioActualizacionStockDao.java
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

import com.cencosud.mobile.dao.domain.HorarioActualizacionStock;

/**
 * @description Interface  
 */
public interface HorarioActualizacionStockDao {

	public List<HorarioActualizacionStock> getHorarioActualizacionStocks(int start, int limit);
	
}
