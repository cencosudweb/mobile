
/**
 *@name QuestionServicesImpl.java
 * 
 *@version 1.0 
 * 
 *@date 07-03-2017
 * 
 *@author EA7129
 * 
 *@copyright Cencosud. All rights reserved.
 */
package com.cencosud.mobile.core.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cencosud.mobile.core.QuestionServices;
import com.cencosud.mobile.core.util.MD5HashingUtils;
import com.cencosud.mobile.dao.QuestionDao;
import com.cencosud.mobile.dao.domain.Question;
import com.cencosud.mobile.dao.domain.QuestionAnswer;
import com.cencosud.mobile.dao.domain.User;
import com.cencosud.mobile.dto.users.QuestionAnswerDTO;
import com.cencosud.mobile.dto.users.QuestionDTO;
import com.cencosud.mobile.utils.OperationResult;

/**
 * @description   
 */
@Repository
public class QuestionServicesImpl extends BaseServicesImpl implements QuestionServices {

	@Autowired
	private QuestionDao questionDaoImpl;

	private static Logger log = Logger.getLogger(QuestionServicesImpl.class);

	@Override
	@Transactional
	public List<QuestionDTO> getQuestions() {
		List<QuestionDTO> result = new ArrayList<QuestionDTO>();

		List<Question> questions;
		try {

			questions = questionDaoImpl.getQuestions();
			if (questions != null && !questions.isEmpty()) {

				for (Question question : questions) {

					QuestionDTO questionDestination = new QuestionDTO();
					mapper.map(question, questionDestination);
					result.add(questionDestination);
				}

			}

		} catch (Exception e) {
			log.error("Error inesperado", e);
		}

		return result;
	}

	@Override
	@Transactional(readOnly=false)
	public OperationResult addQuestionAnswer(Long idUser, List<QuestionAnswerDTO> qas) {
		OperationResult result = new OperationResult();

		User owner = new User();
		owner.setId(idUser);
		Set<User> users = new HashSet<User>();
		users.add(owner);

		try {

			if (qas != null && !qas.isEmpty()) {
				for (QuestionAnswerDTO qaSource : qas) {
					
					//encripta respuesta
					qaSource.setAnswer(MD5HashingUtils.encrypt(qaSource.getAnswer()));

					QuestionAnswer qaDestination = mapper.map(qaSource, QuestionAnswer.class);
					qaDestination.setUsers(users);

					questionDaoImpl.addQuestionAnswer(qaDestination);

				}

				result.setResult(OperationResult.SUCCESS);
				result.setMessage("Preguntas-respuestas registradas exitosamente");
			} else {
				result.setResult(OperationResult.ERROR);
				result.setMessage("No hay preguntas-respuestas para ingresar");
			}

		} catch (Exception e) {
			log.error("Error inesperado", e);
			result.setExcepcion(e);
			result.setResult(OperationResult.ERROR);
			result.setMessage("Error al registrar preguntas-respuestas");
		}

		return result;
	}

}