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

import com.cencosud.mobile.core.EstadoResponsableServices;
import com.cencosud.mobile.dto.users.EstadoResponsableDTO;

/**
 * 
 * @author jose
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/mobile-testContext.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
public class EstadoResponsableServicesTest{

	@Autowired
	private EstadoResponsableServices estadoResponsableServicesImpl;
	
	@Test
	@Transactional
    public void getEstadoResponsablesTest() {
		
		List<EstadoResponsableDTO> estados = estadoResponsableServicesImpl.getEstadoResponsables();
		
		assertNotNull("Listado de Estado es null", estados);
		assertFalse("No hay Estado", estados.isEmpty());
		
		
    }
	
	
}
