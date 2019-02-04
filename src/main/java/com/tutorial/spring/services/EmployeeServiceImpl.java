package com.tutorial.spring.services;

import com.tutorial.spring.models.Employee;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by mberhe on 2/4/19.
 */
public class EmployeeServiceImpl implements EmployeeService, InitializingBean, DisposableBean {
    private Employee employee;

    public EmployeeServiceImpl() {
        System.out.println("EmployeeService no-args constructor called");
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("EmployeeService Closing resources");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("EmployeeService initializing to dummy value");
        if(employee.getName() == null){
            employee.setName("Pankaj");
        }
    }
}
