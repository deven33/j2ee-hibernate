package com.hibernate.curd.dao;

import java.util.List;

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
			
			System.out.println("update student data");
			
			//start transaction
			session.beginTransaction();
			int id=3;
			// for single update
		/*	StudentEntity se= session.get(StudentEntity.class, id);
			se.setFname("Cartoon");
		*/	//update data
			
			// for bulk update
			
			session.createQuery("update StudentEntity s set s.email='test@cts.com' where s.lname='syedd'").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("update done!!");
		}
		finally {

			sf.close();
		}
	}
}
