package com.prowings;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class CarRepository {

	public static void main(String[] args) {

		Car car1 = new Car("BMW", "Sport", 1111111);
		Car car2 = new Car("Audi", "Sedan", 6666666);
		Car car3 = new Car("Toyota", "SUV", 999999);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = null;
		Transaction txn = null;
		
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			
//			List < Object > totalCars = session.createNamedQuery("GET_CARS_COUNT").getResultList();
//            System.out.println("Total Students: " + totalCars.get(0));
			txn.commit();
			
		}catch (Exception e) {
			if(txn != null)
				txn.rollback();
		}

	}
	
	

}
