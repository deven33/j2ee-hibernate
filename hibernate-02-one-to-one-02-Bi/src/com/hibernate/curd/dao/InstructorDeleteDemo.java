package com.hibernate.curd.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.curd.entity.Instructor;
import com.hibernate.curd.entity.InstructorDetail;

public class InstructorDeleteDemo {

	public static void main(String[] args) {
		
		SessionFactory sf= new Configuration().configure()
				.addAnnotatedClass(Instructor.class).
				 addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		//create session
		Session session = sf.getCurrentSession();;
		
		
		try {
			session.beginTransaction();
			int id=2;
			Instructor instructor=session.get(Instructor.class, id);
			if(instructor!=null) {
				session.delete(instructor);
			}
			session.getTransaction().commit();
			
		}
		finally {

			sf.close();
		}
	}
}
