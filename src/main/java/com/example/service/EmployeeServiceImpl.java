package com.example.service;

import com.example.model.Employee;
import com.example.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private final IEmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findOne(String id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> findByEmployeeName(String name, Pageable pageable) {
        return employeeRepository.findByEmployeeName(name, pageable);
    }

    @Override
    public Page<Employee> findByEmployeeNameUsingCustomQuery(String name, Pageable pageable) {
        return null;
    }

    @Override
    public long count() {
        return employeeRepository.count();
    }

    @Override
    public void delete(Employee employee) {
       employeeRepository.delete(employee);
    }
}
