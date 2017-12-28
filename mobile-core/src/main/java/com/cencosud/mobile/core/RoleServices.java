/**
 * @name RoleServices.java
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

import com.cencosud.mobile.dto.users.RoleDTO;
import com.cencosud.mobile.utils.OperationResult;
/**
 * @description   
 */
public interface RoleServices {

	public List<RoleDTO> getRolesByUser(Long userId);
	public List<RoleDTO> getRoles(boolean includeAdmin);
	public OperationResult addRole(RoleDTO role);
	public OperationResult deleteRole(RoleDTO role);
	public OperationResult addRoleForUser(Long idUser, Long idRole);
	public OperationResult deleteRoleForUser(Long idUser, Long idRole);
	public RoleDTO getRole(String id);
	
}
