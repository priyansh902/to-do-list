package com.example.todo.Repositiory;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.todo.Model.model;


public interface repositiory extends JpaRepository<model, Long> {
    
}
