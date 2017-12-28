/**
 *@name HorarioVentaEnVerdeActualizacionDaoImpl.java
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

import com.cencosud.mobile.dao.HorarioVentaEnVerdeActualizacionDao;
import com.cencosud.mobile.dao.domain.HorarioVentaEnVerdeActualizacion;
/**
 * @description Clase HorarioVentaEnVerdeActualizacionDaoImpl que implementa la interface
 */
@Repository
public class HorarioVentaEnVerdeActualizacionDaoImpl implements HorarioVentaEnVerdeActualizacionDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<HorarioVentaEnVerdeActualizacion> getHorarioVentaEnVerdeActualizacions(int start, int limit) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(HorarioVentaEnVerdeActualizacion.class);
			//cr.add(Restrictions.eq("id", userId));
		cr.setFirstResult(start * 1);
		cr.setMaxResults(limit);
		cr.addOrder(Order.desc("fecha"));
		return (List<HorarioVentaEnVerdeActualizacion>) cr.list();
	}

}
