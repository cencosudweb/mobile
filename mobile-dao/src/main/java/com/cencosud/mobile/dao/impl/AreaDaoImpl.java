/**
 *@name AreaDaoImpl.java
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

import com.cencosud.mobile.dao.AreaDao;
import com.cencosud.mobile.dao.domain.Area;
/**
 * @description Clase AreaDaoImpl que implementa la interface
 */
@Repository
public class AreaDaoImpl implements AreaDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Area> getAreas() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Area.class);
			//cr.add(Restrictions.eq("id", userId));
		return (List<Area>) cr.list();
	}

}
