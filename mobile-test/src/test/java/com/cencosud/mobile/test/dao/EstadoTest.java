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

import com.cencosud.mobile.dao.EstadoDao;
import com.cencosud.mobile.dao.domain.Estado;

/**
 * @description Clase ChannelTest que implementa pruebas Unitarias
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/mobile-testContext.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
public class EstadoTest{

	@Autowired
	private EstadoDao estadoDaoImpl;
	
	@Test
	@Transactional
    public void getEstadosTest() {
		List<Estado> estados = estadoDaoImpl.getEstados();
		assertNotNull("Listado de canales es null", estados);
		assertFalse("No hay canales", estados.isEmpty());
	
    }
	
	@Test
	@Transactional
	public void getEstadoIdTest() {
		Estado estados = estadoDaoImpl.getEstadosId(new Long(1));
		assertNotNull("Listado de Estado es null", estados);

	}
	
}
