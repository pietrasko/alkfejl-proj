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
import hu.elte.alkfejl.csaladitodo.model.Registration;
import hu.elte.alkfejl.csaladitodo.model.User;
import hu.elte.alkfejl.csaladitodo.repository.RegRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class RegService {
    private Registration reg_table;
    
    @Autowired
    private RegRepository regRepo;
    
    private Registration addNewRegistration(Admin admin, String username){
        String code = admin.genRegCode();
        Registration reg = new Registration();
        reg.setName(username);
        reg.setCode(code);
        return regRepo.save(reg);
    }
    
    private boolean registeringUserIsPresent(User user){
        Optional<Registration> reg = regRepo.findByName(user.getUsername());
        if(reg.isPresent()){
            regRepo.delete(reg.get());
            return true;
        }
        return false;
    }
}
