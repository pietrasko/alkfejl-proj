package hu.elte.alkfejl.csaladitodo.controller;

import hu.elte.alkfejl.csaladitodo.model.Task;
import hu.elte.alkfejl.csaladitodo.service.RegService;
import hu.elte.alkfejl.csaladitodo.service.TaskService;
import hu.elte.alkfejl.csaladitodo.service.UserService;
import java.text.ParseException;
import hu.elte.alkfejl.csaladitodo.annotation.Role;
import static hu.elte.alkfejl.csaladitodo.model.User.Role.ADMIN;
import static hu.elte.alkfejl.csaladitodo.model.User.Role.USER;
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

/**
 *
 * @author GenQP
 */
@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    
    @Autowired
    private RegService regService;
    
    @Autowired
    private UserService userService;
        
    @GetMapping("/tasks")
    public ResponseEntity<Iterable<Task>> list() {
        return ResponseEntity.ok(taskService.listAll());
    }
    
    @Role({ADMIN})
    @PostMapping("/new")
    public ResponseEntity<Task> newTask(@RequestBody Task task) throws ParseException {
        return ResponseEntity.ok(taskService.addTask(task, userService.getLoggedInUser()));
    }
    
    @Role({ADMIN, USER})
    @PutMapping("/edit/{id}")
    public ResponseEntity<Task> editTask(@PathVariable int id, @RequestBody Task task) {
        Task updateTask = taskService.updateTask(id, task);
        return ResponseEntity.ok(updateTask);
    }
    
    @Role({ADMIN})
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }
}
