package com.epam.hujj.training.javapersistence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epam.hujj.training.javapersistence.config.DataSourceConfig;
import com.epam.hujj.training.javapersistence.config.JdbcDaoConfig;
import com.epam.hujj.training.javapersistence.jdbcdao.JdbcHouseDao;
import com.epam.hujj.training.javapersistence.jdbcdao.JdbcTemplateHouseDao;
import com.epam.hujj.training.javapersistence.jdbcdao.JpaHouseDao;
import com.epam.hujj.training.javapersistence.repository.HouseRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	ApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class, JdbcDaoConfig.class);
    	
        JdbcHouseDao houseJdbcDao = context.getBean(JdbcHouseDao.class);
        System.out.printf("The first house in the database is %s.\n", houseJdbcDao.findHouseNameById(1));
        
        
        JdbcTemplateHouseDao jdbcTemplateHouseDao = context.getBean(JdbcTemplateHouseDao.class);
        System.out.printf("The first house in the database is %s.\n", jdbcTemplateHouseDao.findHouseNameById(1));
        
        JpaHouseDao jpaHouseDao = context.getBean(JpaHouseDao.class);
        System.out.printf("The first house in the database is %s.\n", jpaHouseDao.findHouseNameById(1)); 
        
        HouseRepository houseRepository = context.getBean(HouseRepository.class);
        System.out.printf("The first house in the database is %s.\n", houseRepository.findOne(1).getName());
        System.out.printf("The first house in the database is %s.\n", houseRepository.findByName("ddd"));
    }
}
