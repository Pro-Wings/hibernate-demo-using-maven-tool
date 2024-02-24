package com.prowings;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class StudentRepository2 {

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
			
//			String hql = "INSERT INTO Student (name, address, marks) SELECT name, address, marks FROM Student";
			String hql = "FROM Student s WHERE s.id = 2";
			
			Query query = session.createQuery(hql);
			
			List<Student> res = query.getResultList();
			
			System.out.println(res);
			txn.commit();
			
		}catch (Exception e) {
			if(txn != null)
				txn.rollback();
		}

	}
	
	

}
