package com.bjit.training;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.bjit.HYBERNET_QUICK.HibernateUtil;
import com.bjit.training.Employee;

public class HibernateHQL {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {

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

		// HQL example - Get Employee with id
		query = session.createQuery("from Employee where id= :id");
		query.setParameter("id", 2);
		Employee emp = (Employee) query.uniqueResult();
		System.out.println("iiiiiiiiiiiiiddddddddddddEmployee Name=" + emp.getEmpName() + ", City=" + emp.getAddress().getCity());

		String hql = "UPDATE Address set address_line1 = :address_line1 " + "WHERE id = :address_id";
		query = session.createQuery(hql);
		query.setParameter("address_line1", "BJIT1");
		query.setParameter("address_id", 2);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);

		tx.commit();
		System.out.println("Data displayed");

		sessFact.close();
	}
}