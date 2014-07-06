package org.fitnessgym.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private final static SessionFactory sf=buildSessionFactory(); 
	
	private static  SessionFactory buildSessionFactory(){
		return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory(){
		return sf;
	}
	
	
	
	

}
