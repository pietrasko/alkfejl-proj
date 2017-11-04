package hu.elte.alkfejl.csaladitodo.controller;

import hu.elte.alkfejl.csaladitodo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("")
    public ResponseEntity<User> user() {
        if (userService.isLoggedIn()) {
            return ResponseEntity.ok(userService.getLoggedInUser());
        }
        return ResponseEntity.badRequest().build();
    }
    
    @GetMapping("/register")
    public String showRegister(User user) {
       return "register"; 
    }
    
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }
    
    @GetMapping("/login")
    public String showLogin(User user) {
       return "login"; 
    }
    
//    @PostMapping("/login")
        public String login(Model model, User user) {
           if(userService.login(user)) {
               return "redirect:/";
           }
           model.addAttribute("error", true);
           return "login";
        }
    
//    @PostMapping("/logout")
//    public ResponseEntity<User> logout(@RequestBody User user) {
//        userService.logout();
//        return ResponseEntity.ok().build();
//    }
}
