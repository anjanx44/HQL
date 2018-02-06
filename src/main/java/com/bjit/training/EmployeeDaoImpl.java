package com.bjit.training;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.bjit.HYBERNET_QUICK.HibernateUtil;
import com.bjit.training.Employee;

public class EmployeeDaoImpl implements EmployeeDAO {
	public Integer addEmployee(Employee employee) {
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Integer employeeID = null;
		try {
			employeeID = (Integer) session.save(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employeeID;
	}

	public Integer addAddress(Address employee) {
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Integer employeeID = null;
		try {
			employeeID = (Integer) session.save(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employeeID;
	}

	public void showEmploy() {
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		CriteriaQuery<Employee> cq = session.getCriteriaBuilder().createQuery(Employee.class);
		cq.from(Employee.class);
		Query<Employee> query = session.createQuery("FROM Employee");
		List<Employee> employeeList = query.list();

		for (Employee employee : employeeList) {
			System.out.println("ID: " + employee.getId());
			System.out.println("Hello: " + employee.getEmpName());
		}

		tx.commit();
		System.out.println("Data displayed");

//		sessFact.close();

	}

	public void showEmployeeById(int id){
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		
		// HQL example - Get Employee with id
		Query<Employee> query = session.createQuery("FROM Employee WHERE id= :id");
		query.setParameter("id", id);
		Employee emp = (Employee) query.uniqueResult();
		System.out.println("iiiiiiiiiiiiiddddddddddddEmployee Name=" + emp.getEmpName() + ", City=" + emp.getAddress().getCity()+ ", address=" + emp.getAddress().getAddressLine1());


		tx.commit();
		System.out.println("Data displayed");

//		sessFact.close();
	}
	
	
	public void updateAddressById(int id, String address){
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		String hql = "UPDATE Address set address_line1 = :address_line1 " + "WHERE id = :address_id";
		Query<Employee> query = session.createQuery(hql);
		query.setParameter("address_line1", address);
		query.setParameter("address_id", id);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);

		tx.commit();
		System.out.println("Data displayed");
		


//		sessFact.close();
	}

}