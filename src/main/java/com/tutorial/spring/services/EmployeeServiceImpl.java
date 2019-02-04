package com.tutorial.spring.services;

import com.tutorial.spring.dao.EmployeeDao;
import com.tutorial.spring.models.Employee;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mberhe on 2/4/19.
 */
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService, InitializingBean, DisposableBean {

    @Autowired
    private EmployeeDao dao;

    public void saveEmployee(Employee employee) {
        dao.saveEmployee(employee);
    }

    public List<Employee> findAllEmployees() {
        return dao.findAllEmployees();
    }

    public void deleteEmployeeBySsn(String ssn) {
        dao.deleteEmployeeBySsn(ssn);
    }

    public Employee findBySsn(String ssn) {
        return dao.findBySsn(ssn);
    }

    public void updateEmployee(Employee employee){
        dao.updateEmployee(employee);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("EmployeeService Closing resources");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("EmployeeService initializing to dummy value");
    }
}

