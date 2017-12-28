/**
 *@name CuadraturaCtlDaoImpl.java
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
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cencosud.mobile.dao.CuadraturaCtlDao;
import com.cencosud.mobile.dao.domain.CuadraturaCtl;
/**
 * @description Clase CuadraturaCtlDaoImpl que implementa la interface
 */
@Repository
public class CuadraturaCtlDaoImpl implements CuadraturaCtlDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<CuadraturaCtl> getCuadraturaCtls(int carga, int bogeda, String fechaIni, String fechaTer, String tipo,
			int tranNbr, int encontrados, int start, int limit) {
		// TODO Auto-generated method stub
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(CuadraturaCtl.class);
		// cr.add(Restrictions.eq("id", userId));
		if (fechaIni != null) {
			cr.add(Restrictions.ge("fecha", fechaIni));//>=
		}

		if (fechaTer != null) {
			cr.add(Restrictions.le("fecha", fechaTer));///<=
		}

		

		if (tipo != null) {
			cr.add(Restrictions.eq("tipo", tipo));
		}

		if (tranNbr != 0) {
			cr.add(Restrictions.eq("tranNbr", tranNbr));
		}

		if (encontrados != 9) {
			cr.add(Restrictions.eq("encontrados", encontrados));
		}

		
		
		cr.setFirstResult(start * 1);
		cr.setMaxResults(limit);
		cr.addOrder(Order.desc("fecha"));
		return (List<CuadraturaCtl>) cr.list();
	}

	@Override
	public int getCuadraturaCtlContar(int carga, int bogeda, String fechaIni, String fechaTer, String tipo, int tranNbr,
			int encontrados) {
		// TODO Auto-generated method stub
		String sql = " SELECT COUNT(*) FROM cuadratura_ctl ESV  where 1 = 1 ";
		
		
		

		if (fechaIni != null) {
			// sql += " AND c.calldate >= :starttime";
			// Mysql-Sql Server-PostgreSql-Oracle
			sql += " AND ESV.fecha >= :fechaIni";
		}
		
		if (fechaTer != null) {
			// sql += " AND c.calldate >= :starttime";
			// Mysql-Sql Server-PostgreSql-Oracle
			sql += " AND ESV.fecha <= :fechaTer";
		}
		
		
		if (tipo != null) {
			sql += " AND ESV.TIPO = :tipo";
		}

		if (tranNbr != 0) {
			sql += " AND ESV.TRAN_NBR = :tranNbr";
		}

		if (encontrados != 9) {
			sql += " AND ESV.ENCONTRADOS = :encontrados";
		}


		

		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		
		
		

		if (fechaIni != null) {
			query.setParameter("fechaIni", fechaIni);
		}
		
		if (fechaTer != null) {
			query.setParameter("fechaTer", fechaTer);
		}

		if (tipo != null) {
			query.setParameter("tipo", tipo);
		}

		if (tranNbr != 0) {
			query.setParameter("tranNbr", tranNbr);
		}

		if (encontrados != 9) {
			query.setParameter("encontrados", encontrados);
		}



		return ((Number) query.uniqueResult()).intValue();

		// return query.uniqueResult().hashCode();
	}

	

	

	

}
