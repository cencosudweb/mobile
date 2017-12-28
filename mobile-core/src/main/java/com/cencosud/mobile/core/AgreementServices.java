/**
 * @name AgreementServices.java
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

import com.cencosud.mobile.dto.users.AgreementDTO;
import com.cencosud.mobile.utils.OperationResult;
/**
 * @description 
 *
 */

public interface AgreementServices {

	public AgreementDTO getAgreement(Long agreementId);
	public OperationResult addAgreement(AgreementDTO agreement, Long idFI, Long idCommerce);
	public OperationResult updateStatus(Long agreementId, int status);
	public OperationResult editAgreement(AgreementDTO agreement);
	public boolean validateAgreementExist(Long fiId, Long commerceId);
	
}
