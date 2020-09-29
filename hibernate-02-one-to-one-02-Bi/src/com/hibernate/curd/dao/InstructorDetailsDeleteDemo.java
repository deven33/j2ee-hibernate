package com.hibernate.curd.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.curd.entity.Instructor;
import com.hibernate.curd.entity.InstructorDetail;

/**
 * @author deven
 * 
 * deleting id from instructor details will delete 
 * corresponding record from instructor as well
 *
 */
public class InstructorDetailsDeleteDemo {

	public static void main(String[] args) {
		
		SessionFactory sf= new Configuration().configure()
				.addAnnotatedClass(Instructor.class).
				 addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		//create session
		Session session = sf.getCurrentSession();;
		int id=2;
		
		try {
			session.beginTransaction();
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			//print the instructor details
			System.out.println("Instructor details:"+instructorDetail);
			
			// print associated instructor
			System.out.println("Associated Instructor:"+instructorDetail.getInstructor());
			
			if(instructorDetail!=null) {
				session.delete(instructorDetail);
			}
			session.getTransaction().commit();
			
		}
		finally {
			sf.close();
		}
	}
}
