/**
 *@name EstadoCumpleResumenDaoImpl.java
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

import com.cencosud.mobile.dao.EstadoCumpleResumenDao;
import com.cencosud.mobile.dao.domain.EstadoCumpleResumen;
/**
 * @description Clase EstadoCumpleResumenDaoImpl que implementa la interface
 */
@Repository
public class EstadoCumpleResumenDaoImpl implements EstadoCumpleResumenDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<EstadoCumpleResumen> getEstadoCumpleResumens() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(EstadoCumpleResumen.class);
			//cr.add(Restrictions.eq("id", userId));
		cr.addOrder(Order.desc("description"));
		return (List<EstadoCumpleResumen>) cr.list();
	}

}
