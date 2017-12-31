package hu.elte.alkfejl.csaladitodo.controller;

import hu.elte.alkfejl.csaladitodo.model.Task;
import hu.elte.alkfejl.csaladitodo.model.User;
import hu.elte.alkfejl.csaladitodo.service.AdminService;
import hu.elte.alkfejl.csaladitodo.service.RegService;
import hu.elte.alkfejl.csaladitodo.service.TaskService;
import hu.elte.alkfejl.csaladitodo.service.UserService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author GenQP
 */
@Controller
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
        
    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("tasks", taskService.listAll());
        return "api/task/list";
    }
    
    @GetMapping("/new")
    public String showNewTask(Model model) {
        if(adminService.isLoggedIn()) {
            model.addAttribute("users", userService.listUsers());
            model.addAttribute("task", new Task());
            return "api/task/new";
        } else {
            return "redirect:/api/admin/login";
        }
    }
    
    @PostMapping("/new")
    public String newTask(Task task, @RequestParam(name = "username", required = true)String username, @RequestParam(name = "deadline", required = true)String deadline) throws ParseException {
        User user = userService.getUserByUsername(username);
        task.setUser(user);
        task.setCompleted(false);
        task.setCompletion_confirmed(false);
        //task.setDeadline((java.sql.Date)new SimpleDateFormat("yyyy-MM-dd").parse(deadline));
        task.setAdmin(adminService.getLoggedInAdmin());
        taskService.addTask(task);
        regService.addNewRegistration(adminService.getLoggedInAdmin(), user.getUsername());
        
        return "redirect:/api/admin/tasks";
    }
    
    @GetMapping("/edit")
    public String showEditTask(@RequestParam(name = "taskid", required = true)int id, Model model) {
        if(adminService.isLoggedIn()) {
            model.addAttribute("task", taskService.getTaskById(id));
            return "api/task/edit";
        } else {
             return "redirect:/api/admin/login";
        }
    }
    
    @PostMapping("/edit")
    public String editTask(Task task,@RequestParam(name = "taskid", required = true)int id,
                            @RequestParam(name = "taskcomp", required = true)boolean completed,
                            @RequestParam(name = "taskconf", required = true)boolean completion_confirmed,
                            @RequestParam(name = "username", required = true)String username,
                            @RequestParam(name = "adminname", required = true)String adminname) {
        task.setId(id);
        task.setAdmin(adminService.getAdminByUsername(adminname));
        task.setCompleted(completed);
        task.setUser(userService.getUserByUsername(username));
        task.setCompletion_confirmed(completion_confirmed);
        taskService.updateTask(task);
        return "redirect:/api/admin/tasks";
    }
    
    @PostMapping("/delete")
    public String deleteTask(@RequestParam(name = "taskid", required = true)int id) {
        if(adminService.isLoggedIn()) { 
            taskService.deleteTask(id);
            return "redirect:/api/admin/tasks";
        } else {
            return "redirect:/api/admin/login";
        }
    }
}
