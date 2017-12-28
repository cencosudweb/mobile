/**
 *@name AgreementServicesTest.java
 * 
 *@version 1.0 
 * 
 *@date 07-03-2017
 * 
 *@author EA7129
 * 
 *@copyright Cencosud. All rights reserved.
 */
package com.cencosud.mobile.test.core;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.cencosud.mobile.core.SkuServicioServices;
import com.cencosud.mobile.dto.users.SkuServicioWsDTO;

/**
 * @description Clase 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/mobile-testContext.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
public class SkuServicioServicesTest{

	@Autowired
	private SkuServicioServices skuServicioServicesImpl;
	
	@Test
	@Transactional
    public void getSkuServiciosTest() {
		
		List<SkuServicioWsDTO> skus = skuServicioServicesImpl.getSkuServicioWs();
		
		assertNotNull("Listado de canales es null", skus);
		assertFalse("No hay canales", skus.isEmpty());
		
		
    }
	
	
}
