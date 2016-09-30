package com.epam.hujj.training.javapersistence.jdbcdao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcTemplateHouseDao extends JdbcDaoSupport {
	private static final String FIND_HOUSE_NAME_BY_ID_SQL = "select name from house where id = ?";
	
	public JdbcTemplateHouseDao(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	public String findHouseNameById(int id) {
		return getJdbcTemplate().queryForObject(FIND_HOUSE_NAME_BY_ID_SQL, String.class, id);
	}
}
