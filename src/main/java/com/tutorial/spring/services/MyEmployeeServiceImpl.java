package com.tutorial.spring.services;

import com.tutorial.spring.models.Employee;

public class MyEmployeeServiceImpl/* implements EmployeeService*/{

	private Employee employee;

	public Employee getEmployee() {
        return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public MyEmployeeServiceImpl(){
		System.out.println("MyEmployeeServiceImpl no-args constructor called");
	}

	//pre-destroy method
	public void destroy() throws Exception {
		System.out.println("MyEmployeeServiceImpl Closing resources");
	}

	//post-init method
	public void init() throws Exception {
		System.out.println("MyEmployeeServiceImpl initializing to dummy value");
		if(employee.getName() == null){
			employee.setName("Pankaj");
		}
	}
}