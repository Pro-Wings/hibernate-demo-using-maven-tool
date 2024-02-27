package com.prowings;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.prowings.enitity.Employee;

public class CriteriaDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		System.out.println(sessionFactory);
		System.out.println("session factory object created successfully!!");

		Session session = sessionFactory.openSession();
		String hql = "From Employee e Where e.department='Marketing'";
//		Query query = session.createQuery(hql);
//		List<Employee> empList = query.getResultList();

		Criteria criteria = session.createCriteria(Employee.class);
		// Retrieve employees in the Marketing department
//		criteria.add(Restrictions.eq("department", "Marketing"));

		// Retrieve employees with salary greater than 50000
//		criteria.add(Restrictions.le("salary", 52000.0));

//		List<Employee> employees = criteria.list();
//		System.out.println(employees);

//		criteria.add(Restrictions.eq("id", 12));
//
//		Employee emp = (Employee) criteria.uniqueResult();
//
//		System.out.println(emp);

		// Retrieve employees aged between 25 and 35, working in either the Marketing or
		// Human Resources department, and earning a salary greater than 48000:
//		criteria.add(Restrictions.between("age", 25, 35));
//		String[] departments = new String[]{"Marketing", "Human Resources"};
//		criteria.add(Restrictions.in("department", departments));
//		criteria.add(Restrictions.gt("salary", 48000.0));
//		List<Employee> employees = criteria.list();
//		
//		System.out.println(employees);

//		Retrieve the average salary of employees in the Marketing department:
//			criteria.setProjection(Projections.avg("salary"));
//			criteria.add(Restrictions.eq("department", "Marketing"));
//			Double averageSalary = (Double) criteria.uniqueResult();		
//		System.out.println("Avg salary from Marketing Dept : "+averageSalary);

		// Retrieve distinct departments where employees are working:
//		criteria.setProjection(Projections.distinct(Projections.property("department")));
//		List<String> departments = criteria.list();
//		System.out.println(departments);

		// Count the total number of employees:
//		criteria.setProjection(Projections.rowCount());
//		Long totalCount = (Long) criteria.uniqueResult();
//		
//		System.out.println("Total Count : "+ totalCount);

//		Retrieve distinct department names with the count of employees in each department:
		ProjectionList projectionList = Projections.projectionList()
				.add(Projections.groupProperty("department"))
				.add(Projections.count("id"));
		criteria.setProjection(projectionList);
		List<Object[]> results = criteria.list();
		
		for (Object[] row : results) {
			String department = (String) row[0];
			Long count = (Long) row[1];
			System.out.println("Department: " + department + ", Count: " + count);
		}
	}

}
