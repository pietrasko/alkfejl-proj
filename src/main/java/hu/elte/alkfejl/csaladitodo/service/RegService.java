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
    private RegRepository regRepository;
    
    private Registration addNewRegistration(Admin admin, String username){
        String code = admin.genRegCode();
        Registration reg = new Registration();
        reg.setName(username);
        reg.setCode(code);
        return regRepository.save(reg);
    }
    
    private boolean registeringUserIsPresent(User user){
        Optional<Registration> reg = regRepository.findByName(user.getUsername());
        if(reg.isPresent()){
            regRepository.delete(reg.get());
            return true;
        }
        return false;
    }
}
