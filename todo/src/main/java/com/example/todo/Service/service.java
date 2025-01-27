package com.example.todo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.Model.model;
import com.example.todo.Repositiory.repositiory;

@Service
public class service {
    @Autowired
    private repositiory taskrepositiory;

    public List<model> getallTasks() {
        return taskrepositiory.findAll();
    }

    public model getTaskBy(Long id){
        return taskrepositiory.findById(id)
        .orElseThrow(() -> new RuntimeException("Task not found " +id));
    }

    public model createTask(model task) {
        return taskrepositiory.save(task);
    }

    public List<model> createtasks(List<model> task){
        return taskrepositiory.saveAll(task);
    }

    public model updatetask(Long id, model updatedTask){
        model existingTask = getTaskBy(id);
        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setCompleted(updatedTask.getCompleted());
        return taskrepositiory.save(existingTask);
    }

    public void deleteTask(Long id){
        taskrepositiory.deleteById(id);
    }
}
