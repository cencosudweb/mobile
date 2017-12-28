/**
 *@name EstadoResponsableDaoImpl.java
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

import com.cencosud.mobile.dao.EstadoResponsableDao;
import com.cencosud.mobile.dao.domain.EstadoResponsable;
/**
 * @description Clase EstadoResponsableDaoImpl que implementa la interface
 */
@Repository
public class EstadoResponsableDaoImpl implements EstadoResponsableDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<EstadoResponsable> getEstadoResponsables() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(EstadoResponsable.class);
			//cr.add(Restrictions.eq("id", userId));
		cr.addOrder(Order.desc("description"));
		return (List<EstadoResponsable>) cr.list();
	}

}
