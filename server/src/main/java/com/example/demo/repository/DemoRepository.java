package com.example.demo.repository;

import com.example.demo.model.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface DemoRepository extends JpaRepository<Demo, Long> {
//    public List<Demo> getAll(){ return new ArrayList<>();}
}
