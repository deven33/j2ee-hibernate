package com.hibernate.curd.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.curd.entity.StudentEntity;

public class StudentDao {

	public static void main(String[] args) {
		
		SessionFactory sf= new Configuration().configure()
				.addAnnotatedClass(StudentEntity.class).buildSessionFactory();
		//create session
		Session session = sf.getCurrentSession();
		
		
		try {
			
			System.out.println("save student data");
			//create student object
			StudentEntity se= new StudentEntity("Shaheen", "syedd", "sanad@cts.com");
			//start transaction
			session.beginTransaction();
			
			//save data
			session.save(se);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("save done!!");
		}
		finally {

			sf.close();
		}
	}
}
