package com.prowings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.prowings.enitity.Department;
import com.prowings.enitity.Employee;

public class EmployeeRepository {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		System.out.println(sessionFactory);
		System.out.println("session factory object created successfully!!");
		
		Employee emp1 = new Employee();
		emp1.setId(1);
		emp1.setName("AAA");
		emp1.setDepartment("IT");
		emp1.setSalary(12345);
		
		Session session1 = sessionFactory.openSession();
		Transaction txn1 = session1.beginTransaction();
		session1.saveOrUpdate(emp1);
		txn1.commit();
		session1.close(); //Since session is closed, the emp1 Object will be in Detached state
		
		emp1.setName("ZZZ"); // performing changes to detached object

		Session session2 = sessionFactory.openSession();
		Transaction txn2 = session2.beginTransaction();
		Employee emp2 = session2.get(Employee.class, 1);

//		session2.update(emp1); //throws NonUniqueObjectException
		session2.merge(emp1);
		txn2.commit();

		
		
	}
	
	

}
