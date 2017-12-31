package hu.elte.alkfejl.csaladitodo.controller;

import hu.elte.alkfejl.csaladitodo.exception.AdminNotValidException;
import hu.elte.alkfejl.csaladitodo.model.Admin;
import hu.elte.alkfejl.csaladitodo.model.Task;
import hu.elte.alkfejl.csaladitodo.model.User;
import hu.elte.alkfejl.csaladitodo.service.AdminService;
import hu.elte.alkfejl.csaladitodo.service.RegService;
import hu.elte.alkfejl.csaladitodo.service.TaskService;
import java.util.Map;
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
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    
    @Autowired
    private TaskService taskService;
    
    @Autowired
    private RegService regService;
    
//    @GetMapping("")
//    public ResponseEntity<Admin> admin() {
//        if (adminService.isLoggedIn()) {
//            return ResponseEntity.ok(
//                    adminService.getLoggedInAdmin());
//        }
//        return ResponseEntity.badRequest().build();
//    }
//    
//    @PostMapping("/login")
//    public ResponseEntity<Admin> login(@RequestBody Admin admin) throws AdminNotValidException {
//        return ResponseEntity.ok(adminService.login(admin));
//    }
//    
//    @PostMapping("/logout")
//    public ResponseEntity<Admin> logout(@RequestBody Admin admin) {
//        adminService.logout();
//        return ResponseEntity.ok().build();
//    }
    
    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("admin", new Admin());
        return "api/admin/login";
    }
    
    @PostMapping("/login")
    public String login(Admin admin) throws AdminNotValidException {
        if(null != adminService.login(admin)) {
            return "redirect:/api/admin/tasks";
        } else {
            return "redirect:/api/admin/login";
        }
    }
    
    @GetMapping("/tasks")
    public String showAdminTasks(Model model) {
        if(adminService.isLoggedIn()) {
            model.addAttribute("tasks",taskService.listByAdmin(adminService.getLoggedInAdmin()));
            model.addAttribute("admin", adminService.getLoggedInAdmin());
            return "api/admin/tasks";
        } else {
            return "redirect:/api/admin/login";
        }
    }
    
    @PostMapping("/logout")
    public String logout(Admin admin) {
        adminService.logout();
        return "redirect:/api/admin/login";
    }
}
