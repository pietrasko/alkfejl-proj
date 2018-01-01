package hu.elte.alkfejl.csaladitodo.controller;

import hu.elte.alkfejl.csaladitodo.model.Task;
import hu.elte.alkfejl.csaladitodo.service.AdminService;
import hu.elte.alkfejl.csaladitodo.service.RegService;
import hu.elte.alkfejl.csaladitodo.service.TaskService;
import hu.elte.alkfejl.csaladitodo.service.UserService;
import java.text.ParseException;
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
    private AdminService adminService;
    
    @Autowired
    private UserService userService;
        
    @GetMapping
    public ResponseEntity<Iterable<Task>> list() {
        return ResponseEntity.ok(taskService.listAll());
    }
    
//    @GetMapping("/new")
//    public String showNewTask(Model model) {
//        if(adminService.isLoggedIn()) {
//            model.addAttribute("users", userService.listUsers());
//            model.addAttribute("task", new Task());
//            return "api/task/new";
//        } else {
//            return "redirect:/api/admin/login";
//        }
//    }
    
    @Role(ADMIN)
    @PostMapping("/new")
    public ResponseEntity<Task> newTask(@RequestBody Task task) throws ParseException {
        return ResponseEntity.ok(taskService.addTask(task, adminService.getLoggedInAdmin()));
    }
    
//    @GetMapping("/edit")
//    public String showEditTask(@RequestParam(name = "taskid", required = true)int id, Model model) {
//        if(adminService.isLoggedIn()) {
//            model.addAttribute("task", taskService.getTaskById(id));
//            return "api/task/edit";
//        } else {
//             return "redirect:/api/admin/login";
//        }
//    }
    
    @Role({ADMIN})
    @PutMapping("/edit/{id}")
    public ResponseEntity<Task> editTask(@PathVariable int id, @RequestBody Task task) {
        Task updateTask = taskService.updateTask(id, task);
        return ResponseEntity.ok(updateTask);
    }
    
    @Role(ADMIN)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }
}
