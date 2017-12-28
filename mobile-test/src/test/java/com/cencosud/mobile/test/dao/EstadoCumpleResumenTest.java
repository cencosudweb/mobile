package com.cencosud.mobile.test.dao;


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

import com.cencosud.mobile.dao.EstadoCumpleResumenDao;
import com.cencosud.mobile.dao.domain.EstadoCumpleResumen;

/**
 * 
 * @author Jose
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/mobile-testContext.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
public class EstadoCumpleResumenTest{

	@Autowired
	private EstadoCumpleResumenDao estadoCumpleResumenDaoImpl;
	
	@Test
	@Transactional
    public void getEstadoCumpleResumenTest() {
		List<EstadoCumpleResumen> estados = estadoCumpleResumenDaoImpl.getEstadoCumpleResumens();
		assertNotNull("Listado de estados Resumen es null", estados);
		assertFalse("No hay estados Resumen", estados.isEmpty());
		
    }
	
}
