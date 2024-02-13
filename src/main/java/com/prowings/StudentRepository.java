package com.prowings;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class StudentRepository {

	public static void main(String[] args) {


		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		
		System.out.println("session factory object created successfully!!");
	}

}
