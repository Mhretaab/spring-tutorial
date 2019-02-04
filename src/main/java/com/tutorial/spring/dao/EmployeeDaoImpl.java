package com.tutorial.spring.dao;

import com.tutorial.spring.models.Employee;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao implements EmployeeDao{

    public void saveEmployee(Employee employee) {
        persist(employee);
    }

    @SuppressWarnings("unchecked")
    public List<Employee> findAllEmployees() {
        /*Criteria criteria = getSession().createCriteria(Employee.class);
        return (List<Employee>) criteria.list();*/

        //Get Criteria Builder
        CriteriaBuilder builder = getSession().getCriteriaBuilder();

        //Create Criteria
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> contactRoot = criteria.from(Employee.class);
        criteria.select(contactRoot);

        //Use criteria to query with session to fetch all contacts
        List<Employee> employees = getSession().createQuery(criteria).getResultList();

        return employees;
    }

    public void deleteEmployeeBySsn(String ssn) {
        Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
        query.setString("ssn", ssn);
        query.executeUpdate();
    }


    public Employee findBySsn(String ssn){
        Criteria criteria = getSession().createCriteria(Employee.class);
        criteria.add(Restrictions.eq("ssn",ssn));
        return (Employee) criteria.uniqueResult();
    }

    public void updateEmployee(Employee employee){
        getSession().update(employee);
    }

}