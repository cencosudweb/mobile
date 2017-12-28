/**
 *@name FlagDao.java
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

import com.cencosud.mobile.dao.domain.Flag;
/**
 * @description Interface  
 */
public interface FlagDao {

	public List<Flag> getFlags();
	
}
