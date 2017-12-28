/**
 *@name CuadraturaCtlServices.java
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

import com.cencosud.mobile.dto.users.CuadraturaCtlDTO;

/**
 * @description Interface  
 */
public interface CuadraturaCtlServices {

	public List<CuadraturaCtlDTO> getCuadraturaCtls(int carga, int bogeda, String fechaIni, String fechaTer, String tipo, int tranNbr, int estado, int start, int limit);
	public int getCuadraturaCtls(int carga, int bogeda, String fechaIni, String fechaTer, String tipo, int tranNbr, int estado);

}
