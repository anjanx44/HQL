package com.bjit.training;

import com.bjit.training.Employee;

public interface EmployeeDAO {

	public Integer addEmployee(Employee employee);
	public Integer addAddress(Address employee);
	public void showEmploy();
	public void showEmployeeById(int id);
	public void updateAddressById(int id, String address);
}
