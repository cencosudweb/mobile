/**
 *@name ContratanteDao.java
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
import com.cencosud.mobile.dao.domain.Gerente;
/**
 * @description Interface  
 */
public interface ContratanteDao {

	public List<Contratante> getContratantes(Gerente gerente);
	public Contratante getContratantesId(Long id);
	
	
	public void addContratante(Contratante contratante);
	public void editContratante(Contratante contratante);
	public void deleteContratante(Long contratanteId);
	
}
