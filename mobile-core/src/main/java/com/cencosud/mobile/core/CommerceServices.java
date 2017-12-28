/**
 * @name ClienteRetiraServices.java
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

import com.cencosud.mobile.dto.users.CommerceDTO;
import com.cencosud.mobile.utils.OperationResult;
/**
 * @description 
 *
 */
public interface CommerceServices {
	public List<CommerceDTO> getCommerces(int status);
	public CommerceDTO getCommerce(Long commerceId);
	public CommerceDTO getCommerceByMnemonic(String mnemonic);
	public CommerceDTO getCommerceByRut(String rut);
	public OperationResult editCommerce(CommerceDTO commerce);
	public OperationResult addCommerce(CommerceDTO commerce);
	public OperationResult deleteCommerce(Long commerceId);
	public OperationResult updateStatus(Long commerceId, int status);
}
