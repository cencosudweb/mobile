/**
 *@name SoporteDao.java
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

import com.cencosud.mobile.dao.domain.Contratante;
import com.cencosud.mobile.dao.domain.Soporte;
/**
 * @description Interface  
 */
public interface SoporteDao {

	public List<Soporte> getSoportes(Contratante contratante);
	public Soporte getSoportesId(Long id);
	
	public void addSoporte(Soporte soporte);
	public void editSoporte(Soporte soporte);
	public void deleteSoporte(Long soporteId);
	
}
