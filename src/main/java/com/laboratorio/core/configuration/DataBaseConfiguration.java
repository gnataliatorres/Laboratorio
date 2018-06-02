package com.laboratorio.core.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataBaseConfiguration {
	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		//properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");   //determina la base de datos que se esta utilizando si se desea trabajar en Oracle u otras aca se cambia
		//properties.put("show_sql", "true");   //manda a imprime en  consola todas las consultas realizadas a la base de datos, util para ver los errores que se creen
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");   
		properties.put("hibernate.dialect.storage_engine", "InnoDB");
		properties.put("show_sql", "true");
		return properties;
		
	}
	//Inyeccion de dependencias
	@Bean
	public DataSource getDataSource() {
		//origen de la condicion, creacion del driver
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost/laboratorio");  //nombre del servidor y base de datos
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}
	//Crea la sesion
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(getDataSource());
		localSessionFactoryBean.setPackagesToScan("com.laboratorio.core.model");  //modelo donde se encuentra las tablas de la base de datos
		localSessionFactoryBean.setHibernateProperties(getHibernateProperties());
		return localSessionFactoryBean;
	}
	//permite transaccionar en la base de datos		
	@Bean
	@Autowired
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}

}
