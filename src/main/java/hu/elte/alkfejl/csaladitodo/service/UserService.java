package hu.elte.alkfejl.csaladitodo.service;

import hu.elte.alkfejl.csaladitodo.exception.UserNotValidException;
import hu.elte.alkfejl.csaladitodo.repository.UserRepository;
import hu.elte.alkfejl.csaladitodo.model.User;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import hu.elte.alkfel.csaladitodo.annotation.Role;

@Service
@SessionScope
public class UserService {
    private User user;
    
    @Autowired
    private UserRepository userRepository;
    
    public User register(User user) {
        //user.setRole(Role.USER);
        return this.user = userRepository.save(user);
    }
    
    public Iterable<User> listUsers() {
        return userRepository.findAll();
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
    
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).get();
    }
}
