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
			
			System.out.println("save student data");
			
			//start transaction
			session.beginTransaction();
			
			//save data
			@SuppressWarnings("unchecked")
			List<StudentEntity> stList= session.createQuery("from StudentEntity s where s.fname='sana'").list();
			System.out.println("test " +stList);
			for(StudentEntity s: stList) {
				System.out.println(s);
			}
			
			//commit transaction
			
			session.getTransaction().commit();
			
			System.out.println("save done!!");
		}
		finally {

			sf.close();
		}
	}
}
