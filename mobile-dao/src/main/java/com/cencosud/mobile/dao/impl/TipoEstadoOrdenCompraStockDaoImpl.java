/**
 *@name TipoEstadoOrdenCompraStockDaoImpl.java
 * 
 *@version 1.0 
 * 
 *@date 07-03-2017
 * 
 *@author EA7129
 * 
 *@copyright Cencosud. All rights reserved.
 */
package com.cencosud.mobile.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cencosud.mobile.dao.TipoEstadoOrdenCompraStockDao;
import com.cencosud.mobile.dao.domain.TipoEstadoOrdenCompraStock;
/**
 * @description Clase TipoEstadoOrdenCompraStockDaoImpl que implementa la interface
 */
@Repository
public class TipoEstadoOrdenCompraStockDaoImpl implements TipoEstadoOrdenCompraStockDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoEstadoOrdenCompraStock> getTipoEstadoOrdenCompraStocks() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(TipoEstadoOrdenCompraStock.class);
			//cr.add(Restrictions.eq("id", userId));
		return (List<TipoEstadoOrdenCompraStock>) cr.list();
	}

}
