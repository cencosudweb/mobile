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

import com.cencosud.mobile.core.HorarioVentaEnVerdeActualizacionServices;
import com.cencosud.mobile.dto.users.HorarioVentaEnVerdeActualizacionDTO;

/**
 * @description Clase 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/mobile-testContext.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
public class HorarioVentaEnVerdeActualizacionServicesTest{

	@Autowired
	private HorarioVentaEnVerdeActualizacionServices horarioVentaEnVerdeActualizacionServicesImpl;
	
	@Test
	@Transactional
    public void getHorarioVentaEnVerdeActualizacionsTest() {
		
		List<HorarioVentaEnVerdeActualizacionDTO> horarios = horarioVentaEnVerdeActualizacionServicesImpl.getHorarioVentaEnVerdeActualizacions(0,1);
		
		assertNotNull("Listado de horarios es null", horarios);
		assertFalse("No hay horarios", horarios.isEmpty());
		
		
    }
	
	
}
