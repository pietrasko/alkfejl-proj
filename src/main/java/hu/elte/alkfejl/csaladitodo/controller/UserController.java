package hu.elte.alkfejl.csaladitodo.controller;

import hu.elte.alkfejl.csaladitodo.exception.UserNotValidException;
import hu.elte.alkfejl.csaladitodo.model.Task;
import hu.elte.alkfejl.csaladitodo.service.UserService;
import hu.elte.alkfejl.csaladitodo.model.User;
import hu.elte.alkfejl.csaladitodo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private TaskService taskService;
    
//    @GetMapping("")
//    public ResponseEntity<User> user() {
//        if (userService.isLoggedIn()) {
//            return ResponseEntity.ok(
//                    userService.getLoggedInUser());
//        }
//        return ResponseEntity.badRequest().build();
//    }
    
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "api/user/regist";
    }
    
    @PostMapping("/register")
    //public User register(@RequestBody User user) {
    public String register(User user) {
        //return userService.register(user);
        userService.register(user);
        return "redirect:/api/user/login";
    }
    
    @GetMapping("/tasks")
    public String showTasks(Model model) {
        if(userService.isLoggedIn()) {
            model.addAttribute("tasks", taskService.listByUser(userService.getLoggedInUser()));
            model.addAttribute("user", userService.getLoggedInUser());
            return "api/user/tasks";  
        } else {
            return "redirect:/api/user/login";
        }
            
    }
    
    @GetMapping("/usertask")
    public String showUserTask(Task task, Model model) {
        model.addAttribute("task", task);
        return "api/user/usertask";
    }
    
//    @PostMapping("/login")
//    public ResponseEntity<User> login(@RequestBody User user) {
//        try {
//            return ResponseEntity.ok(userService.login(user));
//        }
//        catch (UserNotValidException e) {
//            return ResponseEntity.badRequest().build();
//        }
//    }
    
    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("user",new User());
        return "api/user/login";
    }
    
    @PostMapping("/login")
    public String login(User user) throws UserNotValidException {
        if(null != userService.login(user)) {
            return "redirect:/api/user/tasks";
        } else {
            return "redirect:/api/user/login";
        }
    }
    
    @PostMapping("/logout")
    //public ResponseEntity<User> logout(@RequestBody User user) {
    public String logout(User user) {
        userService.logout();
        return "redirect:/api/user/login";
       //return ResponseEntity.ok().build();
    }
}
