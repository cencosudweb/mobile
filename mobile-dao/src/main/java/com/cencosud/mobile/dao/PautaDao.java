/**
 *@name PautaDao.java
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
import com.cencosud.mobile.dao.domain.Estado;
import com.cencosud.mobile.dao.domain.Gerente;
import com.cencosud.mobile.dao.domain.Padrino;
import com.cencosud.mobile.dao.domain.Pauta;
import com.cencosud.mobile.dao.domain.Soporte;
import com.cencosud.mobile.dao.domain.Tienda;
/**
 * @description Interface  
 */
public interface PautaDao {

	public List<Pauta> getPautas();
	public List<Pauta> getPautas(Tienda tienda, Padrino padrino, Gerente gerente, Contratante contratante, Soporte soporte, Estado estado, String fecha, int start, int limit);
	public int getCountPautas(Tienda tienda, Padrino padrino, Gerente gerente, Contratante contratante, Soporte soporte, Estado estado,  String starttime);
	public Pauta getPauta(Long pautaId);
	public int getPautaRandom(int random);
	
	public void addPauta(Pauta pauta);
	public void editPauta(Pauta pauta);
	public void deletePauta(Long pId);
	
	
	
}
