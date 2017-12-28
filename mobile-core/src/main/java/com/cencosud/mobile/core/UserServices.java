/**
 * @name UserServices.java
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
import com.cencosud.mobile.dto.users.UserDTO;
import com.cencosud.mobile.utils.OperationResult;
/**
 * @description   
 */

public interface UserServices {

	public List<UserDTO> getUsers();
	public List<UserDTO> getUsersByStatus(int status);
	public OperationResult addUser(UserDTO user);
	public OperationResult deleteUser(Long userId);
	public OperationResult editUser(UserDTO user);
	public UserDTO getUser(Long userId);
	public UserDTO getUser(String username);
	public UserDTO getUserByRut(String rut);
	public UserDTO getUserByEmail(String email);
	public OperationResult changePassword(Long userId, String newPassword, String oldPassword);
	public OperationResult changePasswordLoggedUser(Long userId, String newPassword, String oldEncryptedPassword);
	public OperationResult resetPassword(Long userId);
	public OperationResult updateAttempts(Long userId, int attempt);
	public OperationResult updateStatus(Long userId, int status);
	public OperationResult addSecretQuestionsAnswers(Long userId, List<QuestionAnswerDTO> questionsAnswers);
	public boolean validateUsernameAvailability(String username);
	
}
