/**
 *@name TipoGuiaDaoImpl.java
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
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cencosud.mobile.dao.TipoOrdenDao;
import com.cencosud.mobile.dao.domain.TipoOrden;
/**
 * @description Clase TipoGuiaDaoImpl que implementa la interface
 */
@Repository
public class TipoOrdenDaoImpl implements TipoOrdenDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoOrden> getTipoOrdens() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(TipoOrden.class);
			//cr.add(Restrictions.eq("id", userId));
		cr.addOrder(Order.desc("description"));
		return (List<TipoOrden>) cr.list();
	}

}
