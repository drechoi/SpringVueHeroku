package com.example.demo.repository;

import com.example.demo.model.Demo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DemoRepository {
    public List<Demo> getAll(){ return new ArrayList<>();}
}
