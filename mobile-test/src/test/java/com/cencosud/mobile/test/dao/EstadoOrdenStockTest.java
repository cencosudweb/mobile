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

import com.cencosud.mobile.dao.EstadoOrdenStockDao;
import com.cencosud.mobile.dao.domain.EstadoOrdenStock;

/**
 * @description Clase ChannelTest que implementa pruebas Unitarias
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/mobile-testContext.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
public class EstadoOrdenStockTest{

	@Autowired
	private EstadoOrdenStockDao estadoOrdenStockDaoImpl;
	
	@Test
	@Transactional
    public void getEstadoOrdenStocksTest() {
		List<EstadoOrdenStock> ordenes = estadoOrdenStockDaoImpl.getEstadoOrdenStocks();
		assertNotNull("Listado de ordenes es null", ordenes);
		assertFalse("No hay ordenes", ordenes.isEmpty());
		for(int i=0; i<ordenes.size(); i++){
			System.out.println(ordenes.get(i).getId());
		}
    }
	
}
