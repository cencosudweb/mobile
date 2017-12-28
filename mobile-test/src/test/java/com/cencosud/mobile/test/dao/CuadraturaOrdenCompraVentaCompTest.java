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

import com.cencosud.mobile.dao.CuadraturaOrdenCompraVentaCompDao;
import com.cencosud.mobile.dao.domain.CuadraturaOrdenCompraVentaComp;

/**
 * @description Clase ChannelTest que implementa pruebas Unitarias
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/mobile-testContext.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
public class CuadraturaOrdenCompraVentaCompTest{

	@Autowired
	private CuadraturaOrdenCompraVentaCompDao cuadraturaOrdenCompraVentaCompDaoImpl;
	
	@Test
	@Transactional
    public void getCuadraturaOrdenCompraVentaCompsTest() {
		List<CuadraturaOrdenCompraVentaComp> channels = cuadraturaOrdenCompraVentaCompDaoImpl.getCuadraturaOrdenCompraVentaComps("20170611");
		assertNotNull("Listado de canales es null", channels);
		assertFalse("No hay canales", channels.isEmpty());
		for(int i=0; i<channels.size(); i++){
			System.out.println(channels.get(i).getId());
		}
    }
	
}
