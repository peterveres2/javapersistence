package com.epam.hujj.training.javapersistence.jdbcdao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.epam.hujj.training.javapersistence.domain.House;

public class JpaHouseDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public String findHouseNameById(int id) {
		return entityManager.find(House.class, id).getName();		
	} 
	

}
