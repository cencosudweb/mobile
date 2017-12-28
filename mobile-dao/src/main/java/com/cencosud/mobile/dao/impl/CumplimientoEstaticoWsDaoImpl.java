/**
 *@name CumplimientoEstaticoWsDaoImpl.java
 * 
 *@version 1.0 
 * 
 *@date 07-03-2017
 * 
 *@author EA7129
 * 
 *@copyright Cencosud. All rights reserved.
 */
/**
 *@name CumplimientoDaoImpl.java
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

import com.cencosud.mobile.dao.CumplimientoEstaticoWsDao;
import com.cencosud.mobile.dao.domain.CumplimientoEstaticoWs;

/**
 * @description EA7129
 *
 */

@Repository
public class CumplimientoEstaticoWsDaoImpl implements CumplimientoEstaticoWsDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<CumplimientoEstaticoWs> getCumplimientoEstaticoWss() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(CumplimientoEstaticoWs.class);
			//cr.add(Restrictions.eq("id", userId));
		return (List<CumplimientoEstaticoWs>) cr.list();
	}
}
