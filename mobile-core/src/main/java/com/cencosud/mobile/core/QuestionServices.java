/**
 * @name QuestionServices.java
 * 
 * @version 1.0
 * 
 * @date 13/11/2016
 * 
 * @author josef_000
 * 
 * @copyright 
 * 
 */
package com.cencosud.mobile.core;

import java.util.List;

import com.cencosud.mobile.dto.users.QuestionAnswerDTO;
import com.cencosud.mobile.dto.users.QuestionDTO;
import com.cencosud.mobile.utils.OperationResult;
/**
 * @description   
 */
public interface QuestionServices {

	public List<QuestionDTO> getQuestions();
	public OperationResult addQuestionAnswer(Long idUser, List<QuestionAnswerDTO> qas);
	
}
