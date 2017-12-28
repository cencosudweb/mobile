/**
 * @name PasswordGenerator.java
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

import java.util.Random;


/**
 * @description 
 *
 */
public class PasswordGenerator {


	 static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	 static Random rnd = new Random();

	 public static String randomPassword(int len) 
	 {
	    StringBuilder sb = new StringBuilder( len );
	    for( int i = 0; i < len; i++ ) 
	       sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	    return sb.toString();
	 }

}
