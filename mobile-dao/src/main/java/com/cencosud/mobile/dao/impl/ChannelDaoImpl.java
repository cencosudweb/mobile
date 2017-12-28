/**
 *@name ChannelDaoImpl.java
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

import com.cencosud.mobile.dao.ChannelDao;
import com.cencosud.mobile.dao.domain.Channel;
/**
 * @description Clase ChannelDaoImpl que implementa la interface
 */
@Repository
public class ChannelDaoImpl implements ChannelDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Channel> getChannels() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Channel.class);
			//cr.add(Restrictions.eq("id", userId));
		return (List<Channel>) cr.list();
	}

}
