package com.prowings;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class StudentRepository4 {

	public static void main(String[] args) {

		Student s1 = new Student("Sham", "Mumbai", 99);
		Student s2 = new Student("AAA", "VVV", 99);
		Student s3 = new Student("NNN", "MMM", 99);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = null;
		Transaction txn = null;
		
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			
			String sql = "Select * FROM studentdata";
			
			Query query = session.createSQLQuery(sql);
			
			List<Student> list = query.getResultList();
			
			System.out.println(list);
			
			txn.commit();
			
		}catch (Exception e) {
			if(txn != null)
				txn.rollback();
		}

	}
	
	

}
