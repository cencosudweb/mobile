/**
 *@name ChannelServices.java
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

import com.cencosud.mobile.dto.users.TiendaDTO;
import com.cencosud.mobile.utils.OperationResult;
/**
 * @description   
 */
public interface TiendaServices {

	public List<TiendaDTO> getTiendas();
	public TiendaDTO getTiendasId(Long id);
	public TiendaDTO getTienda(String description);
	public OperationResult deleteTienda(Long tiendaId);
	public OperationResult addTienda(TiendaDTO tienda);
	public OperationResult editTienda(TiendaDTO tienda);
	
}
