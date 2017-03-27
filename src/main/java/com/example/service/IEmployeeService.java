package com.example.service;


import com.example.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Employee save(Employee employee);

    Employee findOne(String id);

    Iterable<Employee> findAll();

    Page<Employee> findByEmployeeName(String name, Pageable pageable);

    Page<Employee> findByEmployeeNameUsingCustomQuery(String name, Pageable pageable);

    long count();

    void delete(Employee employee);

}
