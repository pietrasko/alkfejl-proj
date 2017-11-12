/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.csaladitodo.service;

import hu.elte.alkfejl.csaladitodo.model.Admin;
import hu.elte.alkfejl.csaladitodo.model.Task;
import hu.elte.alkfejl.csaladitodo.model.User;
import hu.elte.alkfejl.csaladitodo.repository.AdminRepository;
import hu.elte.alkfejl.csaladitodo.repository.TaskRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import utils.Role;
/**
 *
 * @author GenQP
 */
@Service
@SessionScope
public class TaskService {
    private Task task;
    
    @Autowired
    private TaskRepository taskRepo;
    
    public Task addTask(Task task){
        return taskRepo.save(task);
    }
    
    public void deleteTask(int id){
        taskRepo.delete(id);
    }
    
    public void updateTask(Task task){
        Task delete = taskRepo.findOne(task.getId());
        if(delete != null){
            taskRepo.delete(delete);
            taskRepo.save(task);
        }
    }
    
    public Iterable<Task> listByUser(User user){
        return taskRepo.findAllByUser(user);
    }
    
    public Iterable<Task> listAll(Admin admin){
        return taskRepo.findAllByAdmin(admin);
    }
}
