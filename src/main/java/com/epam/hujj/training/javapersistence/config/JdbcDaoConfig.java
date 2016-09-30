package com.epam.hujj.training.javapersistence.config;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.epam.hujj.training.javapersistence.jdbcdao.JdbcHouseDao;
import com.epam.hujj.training.javapersistence.jdbcdao.JdbcTemplateHouseDao;
import com.epam.hujj.training.javapersistence.jdbcdao.JpaHouseDao;

@Configuration
@EnableJpaRepositories(basePackages = "com.epam.hujj.training.javapersistence.repository")
public class JdbcDaoConfig {

	@Bean
	public JdbcHouseDao houseJdbcDao() {
		return new JdbcHouseDao();
	}
	
	@Bean
	public JpaHouseDao houseJpaDao() {
		return new JpaHouseDao();
	}
		
	
	@Bean
	public JdbcTemplateHouseDao jdbcTemplateHouseDao(DataSource dataSource) {
		return new JdbcTemplateHouseDao(dataSource);
	}
	
	
	
}
