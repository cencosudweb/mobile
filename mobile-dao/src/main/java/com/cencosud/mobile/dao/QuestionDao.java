/**
 *@name QuestionDao.java
 * 
 *@version 1.0 
 * 
 *@date 07-03-2017
 * 
 *@author EA7129
 * 
 *@copyright Cencosud. All rights reserved.
 */
package com.cencosud.mobile.dao;

import java.util.List;

import com.cencosud.mobile.dao.domain.Question;
import com.cencosud.mobile.dao.domain.QuestionAnswer;
/**
 * @description Interface  
 */
public interface QuestionDao {

	public List<Question> getQuestions();
	public void addQuestionAnswer(QuestionAnswer qa);
	public void deleteQuestionAnswerForUser(Long userId);
	
}
