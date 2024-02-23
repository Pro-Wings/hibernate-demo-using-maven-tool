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

public class StudentRepository {

	public static void main(String[] args) {

//		Student s1 = new Student("Ram", "Pune", 99);

		Car car1 = new Car("Suzuki", "HatchBack", 10000000);
		
		Employee emp1 = new Employee("Ram", "HR", 20000);
		Department dept = new Department("HR");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		System.out.println(sessionFactory);
		
		System.out.println("session factory object created successfully!!");
		
		Session session = sessionFactory.openSession();
		
		Transaction txn = session.beginTransaction();
//		session.save(s1);
//		s1.setAddress("Dubai");
//		session.save(car1);
		session.save(emp1); //Persistent state
		
		session.evict(emp1); //Detached state
		
		emp1.setName("Sham"); //made change to detached instance
		
//		Employee mergedEmp = (Employee) session.merge(emp1);
//		System.out.println(">>>>>>>>>> "+mergedEmp);
		
		session.update(emp1);
		
//		session.save(dept);
		
//		Car car = session.get(Car.class, 11);
//		Car car = (Car) session.get("com.prowings.Car", 1);

//		Car car = session.load(Car.class, 11);
		
		
		
//		System.out.println(">>>>>>>>"+session.getEntityName(car));
//		System.out.println("Retrived Car : "+car);
		
		txn.commit();
		session.close();
		System.out.println("Student saved to DB successfully!!");
		sessionFactory.close();
	}
	
	

}
