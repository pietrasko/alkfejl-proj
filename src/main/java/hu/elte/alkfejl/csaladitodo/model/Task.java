/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.csaladitodo.model;

/**
 *
 * @author GenQP
 */
import java.sql.Timestamp;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TASK")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    
    @JoinColumn
    @ManyToOne(targetEntity = Admin.class)
    private Admin admin;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @JoinColumn
    @ManyToOne(targetEntity = User.class)
    private User user;
    
    @Column(nullable = false)
    private boolean completed;
    
    @Column(nullable = false)
    private boolean completion_confirmed;
    
    @Column(nullable = false)
    private String task_description;
    
    @Column(nullable = false)
    private Timestamp deadline;
}
