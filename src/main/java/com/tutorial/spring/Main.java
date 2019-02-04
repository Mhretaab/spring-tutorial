package com.tutorial.spring;

import com.tutorial.spring.config.BeanConfiguration;
import com.tutorial.spring.models.Employee;
import com.tutorial.spring.services.Application;
import com.tutorial.spring.services.Driver;
import com.tutorial.spring.services.EmployeeService;
import com.tutorial.spring.services.FileService;
import org.joda.time.LocalDate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by mberhe on 2/4/19.
 */
public class Main {
    public static void main(String[] args) {
        /*ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config.xml");
        System.out.println("Spring context initialized");

        EmployeeServiceImpl employeeService = (EmployeeServiceImpl) ctx.getBean("employeeService");

        System.out.println("Bean retrieved from Spring Context");

        System.out.println("Employee Name=" + employeeService.getEmployee().getName());

        ctx.close();
        System.out.println("Spring Context Closed");

        ctx.getBean("myAwareService", MyAwareService.class);

        System.out.println("Environment called");
        Environment env = ctx.getBean(Environment.class);

        System.out.println(env.getProperty("JAVA_HOME"));

        ctx.close();*/

        /*AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(*//*BeanConfiguration.class*//*);
        System.out.println("Spring context initialized");
        ctx.getEnvironment().setActiveProfiles("Development");
        ctx.scan("com.tutorial.spring");
        ctx.refresh();*/

        /*EmployeeServiceImpl employeeService = (EmployeeServiceImpl) ctx.getBean(EmployeeServiceImpl.class);

        System.out.println("Bean retrieved from Spring Context");

        System.out.println("Employee Name=" + employeeService.getEmployee().getName());

        ctx.getBean(MyAwareService.class);

        System.out.println("Environment called");
        Environment env = ctx.getBean(Environment.class);

        System.out.println(env.getProperty("JAVA_HOME"));

        System.out.println("Spring Context Closed");

        System.out.println(ctx.getBeanDefinitionNames().toString());*/

        //Byname Autowiring
        /*Application application = (Application)ctx.getBean("application");
        System.out.println("Application Details : "+application);

        Driver driver = (Driver) ctx.getBean("driver");
        System.out.println("Driver Details : " + driver);

        FileService service = (FileService) ctx.getBean("fileService");

        service.readValues();
        ctx.close();*/

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);

        EmployeeService service = (EmployeeService) context.getBean("employeeService");

        /*
         * Create Employee1
         */
        Employee employee1 = new Employee();
        employee1.setName("Han Yenn");
        employee1.setJoiningDate(new Date());
        employee1.setSalary(new BigDecimal(10000));
        employee1.setSsn("ssn00000001");

        /*
         * Create Employee2
         */
        Employee employee2 = new Employee();
        employee2.setName("Dan Thomas");
        employee2.setJoiningDate(new Date());
        employee2.setSalary(new BigDecimal(20000));
        employee2.setSsn("ssn00000002");

        /*
         * Persist both Employees
         */
        service.saveEmployee(employee1);
        service.saveEmployee(employee2);

        /*
         * Get all employees list from database
         */
        List<Employee> employees = service.findAllEmployees();
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        /*
         * delete an employee
         */
        service.deleteEmployeeBySsn("ssn00000002");

        /*
         * update an employee
         */

        Employee employee = service.findBySsn("ssn00000001");
        employee.setSalary(new BigDecimal(50000));
        service.updateEmployee(employee);

        /*
         * Get all employees list from database
         */
        List<Employee> employeeList = service.findAllEmployees();
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }

        context.close();
    }
}
