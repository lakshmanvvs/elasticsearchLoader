package com.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Map;

@Data
@NoArgsConstructor
@Document(indexName = "employee", type = "employee")
public class Employee {

    @Id
    private String id;

    @Field(type = FieldType.String, searchAnalyzer = "standard", store = true)
    private String name;

    private Double salary;

    private Map<String, Object> details;
}
