/**
 *@name FlagDaoImpl.java
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

import com.cencosud.mobile.dao.FlagDao;
import com.cencosud.mobile.dao.domain.Flag;
/**
 * @description Clase FlagDaoImpl que implementa la interface
 */
@Repository
public class FlagDaoImpl implements FlagDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Flag> getFlags() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Flag.class);
			//cr.add(Restrictions.eq("id", userId));
		return (List<Flag>) cr.list();
	}

}
