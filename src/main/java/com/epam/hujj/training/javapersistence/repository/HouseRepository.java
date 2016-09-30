package com.epam.hujj.training.javapersistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.epam.hujj.training.javapersistence.domain.House;

public interface HouseRepository extends CrudRepository<House, Integer>{


	@Query("select h form h House where name = :name")
	House findByName(@Param("name") String name);
}
