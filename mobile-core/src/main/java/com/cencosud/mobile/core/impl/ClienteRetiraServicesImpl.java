
/**
 *@name ClienteRetiraServicesImpl.java
 * 
 *@version 1.0 
 * 
 *@date 07-03-2017
 * 
 *@author EA7129
 * 
 *@copyright Cencosud. All rights reserved.
 */
package com.cencosud.mobile.core.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cencosud.mobile.dao.ClienteRetiraDao;
import com.cencosud.mobile.dao.domain.ClienteRetira;
import com.cencosud.mobile.dto.users.ClienteRetiraDTO;
import com.cencosud.mobile.core.ClienteRetiraServices;
/**
 * @description   
 */
@Repository
public class ClienteRetiraServicesImpl extends BaseServicesImpl implements ClienteRetiraServices{

	@Autowired
	private ClienteRetiraDao clienteRetiraDaoImpl;
	
	private static Logger log = Logger.getLogger(ClienteRetiraServicesImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<ClienteRetiraDTO> getClienteRetiras() {
		List<ClienteRetiraDTO> result = new ArrayList<ClienteRetiraDTO>();
		
		List<ClienteRetira> clienteRetiras;
		try {
			
			clienteRetiras = clienteRetiraDaoImpl.getClienteRetiras();
			if(clienteRetiras != null && !clienteRetiras.isEmpty()){
				result = (List<ClienteRetiraDTO>) mapper.map(clienteRetiras, List.class);
			}

		} catch (Exception e) {
			log.error("Error inesperado", e);
		}
		
		return result;
	}

	
}
