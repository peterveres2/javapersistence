package com.epam.hujj.training.javapersistence.jdbcdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.hujj.training.javapersistence.exception.JavaTrainingException;


public class JdbcHouseDao {
	private static final String FIND_HOUSE_NAME_BY_ID_SQL = "select name from house where id = ?";
	
	@Autowired
	private DataSource dataSource;
	

	public String findHouseNameById(int id) {
		
		try (Connection connection = dataSource.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(FIND_HOUSE_NAME_BY_ID_SQL)) {
			preparedStatement.setInt(1, id);
			try (ResultSet rs = preparedStatement.executeQuery()) {
				String result;
				if (rs.next()) {					
					result = rs.getString(1);
				}
				else {
					result = "N/A";
				}
				return result;
			}
		}
		catch (SQLException ex) {
			throw new JavaTrainingException(ex.getCause());
		}
		
		
		
	}
}
