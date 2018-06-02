package com.laboratorio.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractSession {
	@Autowired	
	private SessionFactory sessionFactory;
	public Session getSession () {  //se encarga de crear la sesion de conexion 		
		return sessionFactory.getCurrentSession();
	}
}
