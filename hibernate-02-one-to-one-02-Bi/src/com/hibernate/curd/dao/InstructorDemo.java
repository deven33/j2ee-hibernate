package com.hibernate.curd.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.curd.entity.Instructor;
import com.hibernate.curd.entity.InstructorDetail;

public class InstructorDemo {

	public static void main(String[] args) {
		
		SessionFactory sf= new Configuration().configure()
				.addAnnotatedClass(Instructor.class).
				 addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		//create session
		Session session = sf.getCurrentSession();;
		
		
		try {
			
			session.beginTransaction();
			int id=3;
			InstructorDetail instructorDetail1=session.get(InstructorDetail.class,id);
			if(instructorDetail1!=null) {
			session.delete(instructorDetail1);
			}
			session.getTransaction().commit();
			
		}
		finally {

			sf.close();
		}
	}
}
