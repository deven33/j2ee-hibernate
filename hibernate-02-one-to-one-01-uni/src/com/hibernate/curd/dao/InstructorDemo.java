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
			
			//create object
			Instructor instructor=new Instructor("sana2","syedd", "sana@cts.com");
			InstructorDetail instructorDetail=new InstructorDetail("sana2 channel","dancing");
			//associate object
			instructor.setInstructorDetail(instructorDetail);
			//begin transaction 
			session.beginTransaction();
			//save
			session.save(instructor);
			//commit
			session.getTransaction().commit();
			
		}
		finally {

			sf.close();
		}
	}
}
