/**
 *@name CuadraturaOrdenCompraVentaCompServices.java
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

import com.cencosud.mobile.dto.users.CuadraturaOrdenCompraVentaCompDTO;
/**
 * @description Interface CuadraturaOrdenCompraVentaCompServices
 */
public interface CuadraturaOrdenCompraVentaCompServices {

	public List<CuadraturaOrdenCompraVentaCompDTO> getCuadraturaOrdenCompraVentaComps(String starttime);
	
}
