/**
 *@name SoporteDaoImpl.java
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

import com.cencosud.mobile.dao.SoporteDao;
import com.cencosud.mobile.dao.domain.Contratante;
import com.cencosud.mobile.dao.domain.Soporte;
/**
 * @description Clase SoporteDaoImpl que implementa la interface
 */
@Repository
public class SoporteDaoImpl implements SoporteDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Soporte> getSoportes(Contratante contratante) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Soporte.class);
			//cr.add(Restrictions.eq("id", userId));
		
		if(contratante != null ){
			cr.add(Restrictions.eq("contratante", contratante));
		}
		return (List<Soporte>) cr.list();
	}

	@Override
	public Soporte  getSoportesId(Long id) {
		// TODO Auto-generated method stub
		return (Soporte) sessionFactory.getCurrentSession().get(Soporte.class, id);
	}

	@Override
	public void addSoporte(Soporte soporte) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(soporte);
	}

	@Override
	public void editSoporte(Soporte soporte) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(soporte);
	}

	@Override
	public void deleteSoporte(Long soporteId) {
		// TODO Auto-generated method stub
		Soporte soporte = (Soporte) sessionFactory.getCurrentSession().get(Soporte.class, soporteId);
		sessionFactory.getCurrentSession().delete(soporte);
	}

}
