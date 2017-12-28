/**
 *@name GerenteDaoImpl.java
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

import com.cencosud.mobile.dao.GerenteDao;
import com.cencosud.mobile.dao.domain.Gerente;
import com.cencosud.mobile.dao.domain.Padrino;
/**
 * @description Clase GerenteDaoImpl que implementa la interface
 */
@Repository
public class GerenteDaoImpl implements GerenteDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Gerente> getGerentes(Padrino padrino) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Gerente.class);
			//cr.add(Restrictions.eq("id", userId));
		
		if(padrino != null ){
			cr.add(Restrictions.eq("padrino", padrino));
		}
		
		return (List<Gerente>) cr.list();
	}

	@Override
	public Gerente getGerentesId(Long id) {
		// TODO Auto-generated method stub
		return (Gerente) sessionFactory.getCurrentSession().get(Gerente.class, id);
	}

	@Override
	public void addGerente(Gerente gerente) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(gerente);
	}

	@Override
	public void editGerente(Gerente gerente) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(gerente);
	}

	@Override
	public void deleteGerente(Long gerenteId) {
		// TODO Auto-generated method stub
		Gerente gerente = (Gerente) sessionFactory.getCurrentSession().get(Gerente.class, gerenteId);
		sessionFactory.getCurrentSession().delete(gerente);
	}

}
