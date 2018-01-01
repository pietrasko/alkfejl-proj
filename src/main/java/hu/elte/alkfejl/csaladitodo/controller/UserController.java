package hu.elte.alkfejl.csaladitodo.controller;

import hu.elte.alkfejl.csaladitodo.exception.UserNotValidException;
import hu.elte.alkfejl.csaladitodo.model.Task;
import hu.elte.alkfejl.csaladitodo.service.UserService;
import hu.elte.alkfejl.csaladitodo.model.User;
//import hu.elte.alkfejl.csaladitodo.model.User.Role.USER;
import hu.elte.alkfejl.csaladitodo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;
    
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }
    
    //@Role({USER})
    @GetMapping("/tasks")
    public ResponseEntity<Iterable<Task>> showTasks() {
        return ResponseEntity.ok(taskService.listByUser(userService.getLoggedInUser()));
    }
    
    //@Role({USER})
    @GetMapping("/usertask")
    public ResponseEntity<Task> showUserTask(@RequestBody Task task) {
        return ResponseEntity.ok(task);
    }
    
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {  
        try {
            return ResponseEntity.ok(userService.login(user));
        } catch(UserNotValidException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<User> logout(@RequestBody User user) {
        userService.logout();
       return ResponseEntity.status(204).build();
    }
    
    //    @GetMapping("/login")
//    public String showLogin(Model model) {
//        model.addAttribute("user",new User());
//        return "api/user/login";
//    }
    
    //    @GetMapping("/register")
//    public String register(Model model) {
//        model.addAttribute("user", new User());
//        return "api/user/regist";
//    }
}
