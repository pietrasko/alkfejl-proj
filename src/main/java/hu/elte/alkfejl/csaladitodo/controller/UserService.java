package hu.elte.alkfejl.csaladitodo.controller;

import hu.elte.alkfejl.csaladitodo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class UserService {
    private User user;
    
    @Autowired
    private UserRepository userRepository;
    
    public User register(User user) {
        return userRepository.save(user);
    }
    
    public boolean login(User user) {
        if (isValid(user)) {
            return true;
        }
        
        return false;
    }
    
    public boolean isValid(User user) {
        return userRepository.findByUsernameAndPassword(
                user.getUsername(), user.getPassword())
                .isPresent();
    }
    
    public boolean isLoggedIn() {
        return user != null;
    }
    
    public User getLoggedInUser() {
        return user;
    }
    
    public void logout() {
        user = null;
    }
}
