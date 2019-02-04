package com.tutorial.spring;

import com.tutorial.spring.config.BeanConfiguration;
import com.tutorial.spring.services.Application;
import com.tutorial.spring.services.Driver;
import com.tutorial.spring.services.FileService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(/*BeanConfiguration.class*/);
        System.out.println("Spring context initialized");
        ctx.getEnvironment().setActiveProfiles("Development");
        ctx.scan("com.tutorial.spring");
        ctx.refresh();

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
        Application application = (Application)ctx.getBean("application");
        System.out.println("Application Details : "+application);

        Driver driver = (Driver) ctx.getBean("driver");
        System.out.println("Driver Details : " + driver);

        FileService service = (FileService) ctx.getBean("fileService");

        service.readValues();
        ctx.close();
    }
}
