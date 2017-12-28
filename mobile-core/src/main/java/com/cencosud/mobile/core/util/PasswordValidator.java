/**
 * @name PasswordValidator.java
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

package com.cencosud.mobile.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @description 
 *
 */
public class PasswordValidator {

	private static String pattern = null;
	
	private String messageError;

	public PasswordValidator(boolean forceSpecialChar,
													boolean forceCapitalLetter,
													boolean forceNumber,
													int minLength,
													int maxLength){
		
		StringBuilder patternBuilder = new StringBuilder("((?=.*[a-z])");
		StringBuilder messageErrorBuilder = new StringBuilder("Debe cumplir con las siguientes caracteristicas: ");

		if (forceSpecialChar){
			patternBuilder.append("(?=.*[@#$%])");
			messageErrorBuilder.append("Al menos un caracter especial, ");
		}

		if (forceCapitalLetter){
			patternBuilder.append("(?=.*[A-Z])");
			messageErrorBuilder.append("Al menos una letra mayuscula, ");
		}

		if (forceNumber){
			patternBuilder.append("(?=.*\\d)");
			messageErrorBuilder.append("Al menos un numero, ");
		}

		patternBuilder.append(".{" + minLength + "," + maxLength + "})");
		messageErrorBuilder.append("largo minimo de ").append(minLength).append(" y un maximo de ").append(maxLength);
		
		pattern = patternBuilder.toString();
		messageError = messageErrorBuilder.toString();
		
	}

	public boolean validate(final String password) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(password);
		return m.matches();
	}
	
	public String getMessageError() {
		return messageError;
	}

}
