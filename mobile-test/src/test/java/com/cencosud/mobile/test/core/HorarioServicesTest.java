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

import com.cencosud.mobile.core.HorarioServices;
import com.cencosud.mobile.dto.users.HorarioDTO;

/**
 * 
 * @author jose
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/mobile-testContext.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
public class HorarioServicesTest{

	@Autowired
	private HorarioServices HorarioServicesImpl;
	
	@Test
	@Transactional
    public void getHorariosTest() {
		
		List<HorarioDTO> Horarios = HorarioServicesImpl.getHorarios();
		
		assertNotNull("Listado de canales es null", Horarios);
		assertFalse("No hay canales", Horarios.isEmpty());
		
		
    }
	
	
}
