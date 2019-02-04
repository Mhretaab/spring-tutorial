package com.tutorial.spring;

import com.tutorial.spring.config.BeanConfiguration;
import com.tutorial.spring.services.EmployeeService;
import com.tutorial.spring.services.EmployeeServiceImpl;
import com.tutorial.spring.services.MyAwareService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

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

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        System.out.println("Spring context initialized");

        EmployeeServiceImpl employeeService = (EmployeeServiceImpl) ctx.getBean(EmployeeServiceImpl.class);

        System.out.println("Bean retrieved from Spring Context");

        System.out.println("Employee Name=" + employeeService.getEmployee().getName());

        System.out.println("Spring Context Closed");

        //ctx.getBean(MyAwareService.class);

        System.out.println("Environment called");
        Environment env = ctx.getBean(Environment.class);

        System.out.println(env.getProperty("JAVA_HOME"));

        ctx.close();
    }
}
