/**
 *@name TimeLimit.java
 * 
 *@version 1.0 
 * 
 *@date 07-03-2017
 * 
 *@author EA7129
 * 
 *@copyright Cencosud. All rights reserved.
 */

package com.cencosud.mobile.dao.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 * @description Clase TimeLimit
 *
 */

@Entity
@Table(name = "times_limit")
public class TimeLimit implements Serializable {


	private static final long serialVersionUID = 5588247054566763243L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "time_limit_month")
	private Integer timeLimit;
	
	@Column(name = "description")
	private String description;
	
	public TimeLimit() {
	}
	
	public TimeLimit(Long id) {
		this.id = id;
	}
	
	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }


	public void setId(Long id) {
		this.id = id;
	}


	public Long getId() {
		return id;
	}


	public void setTimeLimit(Integer timeLimit) {
		this.timeLimit = timeLimit;
	}


	public Integer getTimeLimit() {
		return timeLimit;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getDescription() {
		return description;
	}




	
}
