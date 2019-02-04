package com.tutorial.spring.config;

import com.tutorial.spring.models.Employee;
import com.tutorial.spring.services.EmployeeServiceImpl;
import com.tutorial.spring.services.MyAwareService;
import com.tutorial.spring.services.MyEmployeeServiceImpl;
import com.tutorial.spring.services.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mberhe on 2/4/19.
 */
@Configuration
public class BeanConfiguration {

    @Bean(name = "employee")
    public Employee getEmployee(){
        return new Employee();
    }

    @Bean
    public EmployeeServiceImpl getEmployeeServiceImpl(){
        EmployeeServiceImpl service = new EmployeeServiceImpl();
        service.setEmployee(getEmployee());
        return service;
    }

    @Bean
    public MyEmployeeServiceImpl getMyEmployeeServiceImpl(){
        MyEmployeeServiceImpl service = new MyEmployeeServiceImpl();
        service.setEmployee(getEmployee());
        return service;
    }

    @Bean
    public CommonAnnotationBeanPostProcessor getCommonAnnotationBeanPostProcessor(){
        return new CommonAnnotationBeanPostProcessor();
    }

    @Bean
    public MyService getMyService(){
        return new MyService();
    }

    @Bean
    public MyAwareService getMyAwareService(){
        return new MyAwareService();
    }

}