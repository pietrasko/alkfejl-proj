package hu.elte.alkfejl.csaladitodo.service;

/**
 *
 * @author GenQP
 */

import hu.elte.alkfejl.csaladitodo.model.Register;
import hu.elte.alkfejl.csaladitodo.model.User;
import hu.elte.alkfejl.csaladitodo.repository.RegRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class RegService {  
    @Autowired
    private RegRepository regRepository;
    
    public Register addNewRegistration(User admin, String username){
        String code = admin.genRegCode();
        Register reg = new Register();
        reg.setUsername(username);
        reg.setCode(code);
        return regRepository.save(reg);
    }
    
    public boolean registeringUserIsPresent(User user){
        Optional<Register> reg = regRepository.findByUsername(user.getUsername());
        if(reg.isPresent()){
            regRepository.delete(reg.get());
            return true;
        }
        return false;
    }
}
