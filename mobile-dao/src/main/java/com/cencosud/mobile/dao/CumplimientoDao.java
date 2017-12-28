/**
 *@name CumplimientoDao.java
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

import com.cencosud.mobile.dao.domain.Cumplimiento;

/**
 * @description Interface  
 */
public interface CumplimientoDao {

	public List<Cumplimiento> getCumplimientos(String fechaIni, String fechaTer);

}
