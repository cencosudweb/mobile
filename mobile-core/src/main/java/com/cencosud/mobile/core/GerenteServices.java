/**
 *@name GerenteServices.java
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

import com.cencosud.mobile.dto.users.GerenteDTO;
import com.cencosud.mobile.dto.users.PadrinoDTO;
import com.cencosud.mobile.utils.OperationResult;
/**
 * @description   
 */
public interface GerenteServices {

	public List<GerenteDTO> getGerentes(PadrinoDTO padrino);
	public GerenteDTO getGerentesId(Long id);
	
	public OperationResult deleteGerente(Long gerenteId);
	public OperationResult addGerente(GerenteDTO gerente);
	public OperationResult editGerente(GerenteDTO gerente);
	
	
}
