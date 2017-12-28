/**
 *@name PadrinoServices.java
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

import com.cencosud.mobile.dto.users.PadrinoDTO;
import com.cencosud.mobile.dto.users.TiendaDTO;
import com.cencosud.mobile.utils.OperationResult;
/**
 * @description   
 */
public interface PadrinoServices {

	public List<PadrinoDTO> getPadrinos(TiendaDTO tienda);
	public List<PadrinoDTO> getPadrinoDescs(String description);
	public PadrinoDTO getPadrinosId(Long id);
	public PadrinoDTO getPadrino(String description);
	
	public OperationResult deletePadrino(Long padrinoId);
	public OperationResult addPadrino(PadrinoDTO padrino);
	public OperationResult editPadrino(PadrinoDTO padrino);
	
}
