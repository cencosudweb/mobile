/**
 * @name FinancialInstitutionServices.java
 * 
 * @version 1.0
 * 
 * @date 13/11/2016
 * 
 * @author josef_000
 * 
 * @copyright 
 * 
 */
package com.cencosud.mobile.core;

import java.util.List;

import com.cencosud.mobile.dto.users.FinancialInstitutionDTO;
import com.cencosud.mobile.utils.OperationResult;
/**
 * @description   
 */

public interface FinancialInstitutionServices {

	public List<FinancialInstitutionDTO> getFIs(int status);
	public FinancialInstitutionDTO getFI(Long fiId);
	public FinancialInstitutionDTO getFIByMnemonic(String mnemonic);
	public FinancialInstitutionDTO getFIByRut(String rut);
	public OperationResult addFI(FinancialInstitutionDTO fi);
	public OperationResult deleteFI(Long fiId);
	public OperationResult editFI(FinancialInstitutionDTO fi);
	public OperationResult updateStatus(Long fiId, int status);
	
}
