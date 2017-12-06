package hu.elte.alkfejl.csaladitodo.service;

import hu.elte.alkfejl.csaladitodo.controller.AdminNotValidException;
import hu.elte.alkfejl.csaladitodo.model.Admin;
import hu.elte.alkfejl.csaladitodo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class AdminService {
    private Admin admin;
    
    @Autowired
    private AdminRepository adminRepository;
    
    public Admin login(Admin admin) throws AdminNotValidException {
        if (isValid(admin)) {
            return this.admin = adminRepository.findByUsername(admin.getUsername()).get();
        }
        throw new AdminNotValidException();
    }
    
    public boolean isValid(Admin user) {
        return adminRepository.findByUsernameAndPassword(
                user.getUsername(), user.getPassword())
                .isPresent();
    }
    
    public boolean isLoggedIn() {
        return admin != null;
    }
    
    public Admin getLoggedInAdmin() {
        return admin;
    }
    
    public void logout() {
        admin = null;
    }
}
