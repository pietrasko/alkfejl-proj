package hu.elte.alkfejl.csaladitodo.controller;

import hu.elte.alkfejl.csaladitodo.model.Admin;
import hu.elte.alkfejl.csaladitodo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author GenQP
 */
@Controller
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    
    @GetMapping("")
    public ResponseEntity<Admin> admin() {
        if (adminService.isLoggedIn()) {
            return ResponseEntity.ok(
                    adminService.getLoggedInAdmin());
        }
        return ResponseEntity.badRequest().build();
    }
    
    @PostMapping("/login")
<<<<<<< Updated upstream
    public ResponseEntity<Admin> login(@RequestBody Admin admin) throws AdminNotValidException {
=======
    public ResponseEntity<Admin> login(@RequestBody Admin admin)
            throws UserNotValidException {
>>>>>>> Stashed changes
        return ResponseEntity.ok(adminService.login(admin));
    }
    
    @PostMapping("/logout")
    public ResponseEntity<Admin> logout(@RequestBody Admin admin) {
        adminService.logout();
        return ResponseEntity.ok().build();
    }
}
