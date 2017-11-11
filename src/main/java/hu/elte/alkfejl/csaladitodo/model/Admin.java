/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.csaladitodo.model;

import java.util.List;
import java.util.Random;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.Role;


/**
 *
 * @author GenQP
 */
@Entity
@Table(name = "ADMIN")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(nullable = false, unique = true)
    private String name;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private Role role;
    
    @Column(nullable = false)
    private String password;
    
    @OneToMany(targetEntity = Task.class, mappedBy = "admin")
    private List<Task> tasks;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setRole(Role role){
        this.role = role;
    }
    
    public String genRegCode() {
        
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
    
}
