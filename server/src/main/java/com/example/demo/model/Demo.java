package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;

@AllArgsConstructor
@Data
public class Demo {
    private Long id;
    private String name;
}
