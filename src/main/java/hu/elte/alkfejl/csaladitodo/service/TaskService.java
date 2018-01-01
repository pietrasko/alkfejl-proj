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
    
    @Autowired
    private RegService regService;
    
    public Task addTask(Task task, Admin admin){
        regService.addNewRegistration(admin, admin.getUsername());
        return taskRepository.save(task);
    }
    
    public void deleteTask(int id){
        taskRepository.delete(id);
    }
    
    public Task updateTask(int id, Task task){
        Task currentTask = taskRepository.findOne(id);
        return taskRepository.save(currentTask);
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
