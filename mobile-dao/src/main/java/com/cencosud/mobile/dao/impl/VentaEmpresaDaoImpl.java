/**
 *@name VentaEmpresaDaoImpl.java
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

import com.cencosud.mobile.dao.VentaEmpresaDao;
import com.cencosud.mobile.dao.domain.VentaEmpresa;
/**
 * @description Clase VentaEmpresaDaoImpl que implementa la interface
 */
@Repository
public class VentaEmpresaDaoImpl implements VentaEmpresaDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<VentaEmpresa> getVentaEmpresas() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(VentaEmpresa.class);
			//cr.add(Restrictions.eq("id", userId));
		cr.addOrder(Order.desc("description"));
		return (List<VentaEmpresa>) cr.list();
	}

}
