package com.example.repository;

import com.example.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends ElasticsearchRepository<Employee, String> {
    Page<Employee> findByEmployeeName(String name, Pageable pageable);

    @Query("{")
    Page<Employee> findByEmployeeCustomQuery(String name, Pageable pageable);
}
