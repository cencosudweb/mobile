/**
 *@name PrioridadDaoImpl.java
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
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cencosud.mobile.dao.PrioridadDao;
import com.cencosud.mobile.dao.domain.Prioridad;
/**
 * @description Clase PrioridadDaoImpl que implementa la interface
 */
@Repository
public class PrioridadDaoImpl implements PrioridadDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Prioridad> getPrioridads() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Prioridad.class);
			//cr.add(Restrictions.eq("id", userId));
		return (List<Prioridad>) cr.list();
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Prioridad> getPrioridadId(Long id) {
		// TODO Auto-generated method stub
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Prioridad.class);
		cr.add(Restrictions.eq("id", id));
		return (List<Prioridad>) cr.list();
	}
	
	
	

}
