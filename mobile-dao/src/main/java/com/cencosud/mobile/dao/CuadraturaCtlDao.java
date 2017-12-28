/**
 *@name CuadraturaCtlDao.java
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

import com.cencosud.mobile.dao.domain.CuadraturaCtl;

/**
 * @description Interface  
 */
public interface CuadraturaCtlDao {

	public List<CuadraturaCtl> getCuadraturaCtls(int carga, int bogeda, String fechaIni, String fechaTer, String tipo, int tranNbr, int estado, int start, int limit);
	public int getCuadraturaCtlContar(int carga, int bogeda, String fechaIni, String fechaTer, String tipo, int tranNbr, int estado);
}
