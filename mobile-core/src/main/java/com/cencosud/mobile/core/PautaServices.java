/**
 *@name PautaServices.java
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
import com.cencosud.mobile.dto.users.EstadoDTO;
import com.cencosud.mobile.dto.users.GerenteDTO;
import com.cencosud.mobile.dto.users.PadrinoDTO;
import com.cencosud.mobile.dto.users.PautaDTO;
import com.cencosud.mobile.dto.users.SoporteDTO;
import com.cencosud.mobile.dto.users.TiendaDTO;
import com.cencosud.mobile.utils.OperationResult;
/**
 * @description   
 */
public interface PautaServices {

	public List<PautaDTO> getPautas();
	public List<PautaDTO> getPautas(TiendaDTO tienda, PadrinoDTO padrino, GerenteDTO gerente, ContratanteDTO contratante, SoporteDTO soporte, EstadoDTO estado, String fecha, int start, int limit);
	public int getCountPautas(TiendaDTO tienda, PadrinoDTO padrino, GerenteDTO gerente, ContratanteDTO contratante, SoporteDTO soporte, EstadoDTO estado, String starttime);
	public int getPautaRandom(int random);
	public PautaDTO getPauta(Long pautaId);
	
	public OperationResult deletePauta(Long pautaId);
	public OperationResult addPauta(PautaDTO pauta);
	public OperationResult editPauta(PautaDTO pauta);


}
