package hu.elte.alkfejl.csaladitodo.service;

import hu.elte.alkfejl.csaladitodo.model.Admin;
import hu.elte.alkfejl.csaladitodo.model.Task;
import hu.elte.alkfejl.csaladitodo.model.User;
import hu.elte.alkfejl.csaladitodo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
/**
 *
 * @author GenQP
 */
@Service
@SessionScope
public class TaskService {
    private Task task;
    
    @Autowired
    private TaskRepository taskRepository;
    
    public Task addTask(Task task){
        return taskRepository.save(task);
    }
    
    public void deleteTask(int id){
        taskRepository.delete(id);
    }
    
    public void updateTask(Task task){
        Task delete = taskRepository.findOne(task.getId());
        if(delete != null){
            taskRepository.delete(delete);
            taskRepository.save(task);
        }
    }
    
    public Task getTaskById(int id) {
        return taskRepository.findOne(id);
    }
    
    public Iterable<Task> listByAdmin(Admin admin) {
        return taskRepository.findByAdmin(admin);
    }
    
    public Iterable<Task> listByUser(User user){
        return taskRepository.findByUser(user);
    }
    
    public Iterable<Task> listAll() {
        return taskRepository.findAll();
    }
}
