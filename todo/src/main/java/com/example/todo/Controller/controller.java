package com.example.todo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.Model.model;

import com.example.todo.Service.service;

@RestController
@RequestMapping("/api/tasks")
public class controller {
    @Autowired
    private service taskservice;

    @GetMapping
    public List<model> getallTasks() {
        return taskservice.getallTasks();  
  }
    
   @GetMapping("/{id}")
      public model getTaskBy(@PathVariable Long id) {
        return taskservice.getTaskBy(id);
   }

      @PostMapping
      public model createTask(@RequestBody model task) {
        return taskservice.createTask(task);
 }

 @PutMapping("/{id}")
 public model updatetask(@PathVariable Long id, @RequestBody model updatedTask) {
   return taskservice.updatetask(id, updatedTask);
 }

 @PostMapping("/bulk")
 public List<model> createtasks(@RequestBody List<model> tasks){
  return taskservice.createtasks(tasks);
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
    taskservice.deleteTask(id);
    return ResponseEntity.noContent().build();
 }



}
