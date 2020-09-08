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
			
			System.out.println("delete student data");
			
			//start transaction
			session.beginTransaction();
			int id=3;
			// for single row delete
		/*	StudentEntity se= session.get(StudentEntity.class, id);
		 * session.delete(se);
			
		*/	
			
			// for bulk update
			
			session.createQuery("delete from StudentEntity s  where s.id=3 ").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("update done!!");
		}
		finally {

			sf.close();
		}
	}
}
