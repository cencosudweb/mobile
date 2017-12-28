/**
 *@name OrdeneStockPendienteServices.java
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

import com.cencosud.mobile.dto.users.OrdeneStockPendienteDTO;
/**
 * @description   
 */
public interface OrdeneStockPendienteServices {

	public List<OrdeneStockPendienteDTO> getOrdeneStockPendientes(String fechaIni, String fechaFin,int orden, String nroDeLinea, String doDtlStatus, String tipoOrden,String pedido,String cantidadPendiente,String bodega,String statCode,int estado, String equalsQhpdDespacha,int start, int limit);
	
}
