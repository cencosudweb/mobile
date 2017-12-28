/**
 *@name SoporteServices.java
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

import com.cencosud.mobile.dto.users.ContratanteDTO;
import com.cencosud.mobile.dto.users.SoporteDTO;
import com.cencosud.mobile.utils.OperationResult;
/**
 * @description   
 */
public interface SoporteServices {

	public List<SoporteDTO> getSoportes(ContratanteDTO contratante);
	public SoporteDTO getSoportesId(Long id);
	
	
	public OperationResult deleteSoporte(Long soporteId);
	public OperationResult addSoporte(SoporteDTO soporte);
	public OperationResult editSoporte(SoporteDTO soporte);
	
}
