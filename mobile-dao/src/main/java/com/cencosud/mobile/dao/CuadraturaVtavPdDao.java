/**
 *@name CuadraturaVtavPdDao.java
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

import com.cencosud.mobile.dao.domain.CuadraturaVtavPd;

/**
 * @description Interface  
 */
public interface CuadraturaVtavPdDao {

	public List<CuadraturaVtavPd> getCuadraturaVtavConPds(String fechaIni, String fechaTer, int tipo_venta, int tipo_numero_distribuicion, int horario);
	public List<CuadraturaVtavPd> getCuadraturaVtavSinPds(String fechaIni, String fechaTer, int tipo_venta, int tipo_numero_distribuicion, int horario);

	public int getCountConOd(String fechaIni, String fechaTer, int tipo_venta, int tipo_numero_distribuicion, int horario);	
	public int getCountSinOd(String fechaIni, String fechaTer, int tipo_venta, int tipo_numero_distribuicion, int horario);	

}
