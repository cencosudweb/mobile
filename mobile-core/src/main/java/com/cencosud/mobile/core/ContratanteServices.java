/**
 *@name ContratanteServices.java
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
import com.cencosud.mobile.dto.users.GerenteDTO;
import com.cencosud.mobile.utils.OperationResult;
/**
 * @description Interface ContratanteServices
 */
public interface ContratanteServices {

	public List<ContratanteDTO> getContratantes(GerenteDTO gerente);
	public ContratanteDTO getContratantesId(Long id);
	
	public OperationResult deleteContratante(Long contratanteId);
	public OperationResult addContratante(ContratanteDTO contratante);
	public OperationResult editContratante(ContratanteDTO contratante);
	
}
