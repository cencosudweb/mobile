/**
 *@name EstadoOrdenStockDaoImpl.java
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

import com.cencosud.mobile.dao.EstadoOrdenStockDao;
import com.cencosud.mobile.dao.domain.EstadoOrdenStock;
/**
 * @description Clase EstadoOrdenStockDaoImpl que implementa la interface
 */
@Repository
public class EstadoOrdenStockDaoImpl implements EstadoOrdenStockDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<EstadoOrdenStock> getEstadoOrdenStocks() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(EstadoOrdenStock.class);
			//cr.add(Restrictions.eq("id", userId));
		return (List<EstadoOrdenStock>) cr.list();
	}

}
