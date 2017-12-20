package hu.elte.alkfejl.csaladitodo.controller;

import hu.elte.alkfejl.csaladitodo.model.Admin;
import hu.elte.alkfejl.csaladitodo.model.Task;
import hu.elte.alkfejl.csaladitodo.model.User;
import hu.elte.alkfejl.csaladitodo.service.RegService;
import hu.elte.alkfejl.csaladitodo.service.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author GenQP
 */
@Controller
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    
    @GetMapping("")
    public Iterable<Task> getTasks(@RequestBody Admin admin) {
        return taskService.listAll(admin);
    }
    
    @GetMapping("/user")
    public Iterable<Task> getTasksByUser(@RequestBody User user) {
        return taskService.listByUser(user);
    }
 
    @GetMapping("/new")
    public Task newTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }
    
    @GetMapping("/edit")
    public void editTask(@RequestBody Task task) {
        taskService.updateTask(task);
    }
    
    @GetMapping("/delete")
    public void deleteTask(@RequestBody int id) {
        taskService.deleteTask(id);
    }
}
