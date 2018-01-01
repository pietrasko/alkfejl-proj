package hu.elte.alkfejl.csaladitodo.controller;

import hu.elte.alkfejl.csaladitodo.exception.AdminNotValidException;
import hu.elte.alkfejl.csaladitodo.model.Admin;
import hu.elte.alkfejl.csaladitodo.model.Task;
//import hu.elte.alkfejl.csaladitodo.model.Admin.Role.ADMIN;
import hu.elte.alkfejl.csaladitodo.service.AdminService;
import hu.elte.alkfejl.csaladitodo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author GenQP
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    
    @Autowired
    private TaskService taskService;
    
    @PostMapping("/login")
    public ResponseEntity<Admin> login(@RequestBody Admin admin) throws AdminNotValidException {
        try {
            return ResponseEntity.ok(adminService.login(admin));
        } catch (AdminNotValidException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    //@Role({ADMIN})
    @GetMapping("/tasks")
    public ResponseEntity<Iterable<Task>> showAdminTasks() {
        return ResponseEntity.ok(taskService.listByAdmin(adminService.getLoggedInAdmin()));
    }
    
    //@Role({ADMIN})
    @GetMapping("/admintask")
    public ResponseEntity<Task> showAdminTask(@RequestBody Task task) {
        return ResponseEntity.ok(task);
    }
    
    @PostMapping("/logout")
    public ResponseEntity<Admin> logout(@RequestBody Admin admin) {
        adminService.logout();
        return ResponseEntity.status(204).build();
    }
    
    //    @GetMapping("/login")
//    public String showLogin(Model model) {
//        model.addAttribute("admin", new Admin());
//        return "api/admin/login";
//    }
}
