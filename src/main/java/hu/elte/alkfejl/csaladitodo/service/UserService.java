package hu.elte.alkfejl.csaladitodo.service;

import hu.elte.alkfejl.csaladitodo.controller.UserNotValidException;
import hu.elte.alkfejl.csaladitodo.repository.UserRepository;
import hu.elte.alkfejl.csaladitodo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import utils.Role;

@Service
@SessionScope
public class UserService {
    private User user;
    
    @Autowired
    private UserRepository userRepository;
    
    public User register(User user) {
        user.setRole(Role.USER);
        return this.user = userRepository.save(user);
    }
    
    public User login(User user) throws UserNotValidException {
        if (isValid(user)) {
            return this.user = userRepository.findByUsername(user.getUsername()).get();
        }
        throw new UserNotValidException();
    }
    
    private boolean isValid(User user) {
        return 
            userRepository.findByUsernameAndPassword(
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
