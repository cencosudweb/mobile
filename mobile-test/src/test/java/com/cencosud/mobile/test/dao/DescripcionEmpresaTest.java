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

import com.cencosud.mobile.dao.DescripcionEmpresaDao;
import com.cencosud.mobile.dao.domain.DescripcionEmpresa;

/**
 * 
 * @author Jose
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/mobile-testContext.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
public class DescripcionEmpresaTest{

	@Autowired
	private DescripcionEmpresaDao descripcionEmpresaDaoImpl;
	
	@Test
	@Transactional
    public void getDescripcionEmpresaTest() {
		List<DescripcionEmpresa> descripcionEmpresas = descripcionEmpresaDaoImpl.getDescripcionEmpresas();
		assertNotNull("Listado de descripcionEmpresa es null", descripcionEmpresas);
		assertFalse("No hay descripcionEmpresa", descripcionEmpresas.isEmpty());
		
    }
	
}
