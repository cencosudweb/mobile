/**
 *@name QuestionDaoImpl.java
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

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cencosud.mobile.dao.QuestionDao;
import com.cencosud.mobile.dao.domain.Question;
import com.cencosud.mobile.dao.domain.QuestionAnswer;
import com.cencosud.mobile.dao.domain.User;
/**
 * @description Clase QuestionDaoImpl que implementa la interface
 */
@Repository
public class QuestionDaoImpl implements QuestionDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getQuestions() {
		return (List<Question>) sessionFactory.getCurrentSession().createQuery("from Question").list();
	}

	@Override
	public void addQuestionAnswer(QuestionAnswer qa) {
		sessionFactory.getCurrentSession().saveOrUpdate(qa);
	}

	@Override
	public void deleteQuestionAnswerForUser(Long userId) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class, userId);
		if(user != null){
			user.getQas().clear();
			sessionFactory.getCurrentSession().update(user);
		}
	}
}