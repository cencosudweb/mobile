/**
 *@name RoleDaoImpl.java
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

import com.cencosud.mobile.dao.SkuServicioWsDao;
import com.cencosud.mobile.dao.domain.SkuServicioWs;

/**
 * @author EA7129
 *
 */

@Repository
public class SkuServicioWsDaoImpl implements SkuServicioWsDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<SkuServicioWs> getSkuServicioWs() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(SkuServicioWs.class);
			//cr.add(Restrictions.eq("id", userId));
		return (List<SkuServicioWs>) cr.list();
	}
}
