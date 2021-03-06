package com.tutorial.spring.services;

import com.tutorial.spring.models.Employee;

import java.util.List;

/**
 * Created by mberhe on 2/4/19.
 */
public interface EmployeeService {

    void saveEmployee(Employee employee);

    List<Employee> findAllEmployees();

    void deleteEmployeeBySsn(String ssn);

    Employee findBySsn(String ssn);

    void updateEmployee(Employee employee);
}
