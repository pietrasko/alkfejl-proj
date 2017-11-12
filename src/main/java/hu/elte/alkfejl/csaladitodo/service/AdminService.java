/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.csaladitodo.service;

/**
 *
 * @author GenQP
 */

import hu.elte.alkfejl.csaladitodo.model.Admin;
import hu.elte.alkfejl.csaladitodo.model.User;
import hu.elte.alkfejl.csaladitodo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import utils.Role;

@Service
@SessionScope
public class AdminService {
    private Admin admin;
    
    @Autowired
    private AdminRepository adminRepo;
    
    public Admin register(Admin admin){
        admin.setRole(Role.ADMIN);
        return adminRepo.save(admin);
    }
    
    public boolean login(Admin user) {
        if (isValid(user)) {
            return true;
        }
        
        return false;
    }
    
    public boolean isValid(Admin user) {
        return adminRepo.findByUsernameAndPassword(
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
