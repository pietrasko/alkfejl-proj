package hu.elte.alkfejl.csaladitodo.model;

/**
 *
 * @author GenQP
 */
import java.sql.Date;
import javax.persistence.*;
import javax.swing.text.StyledEditorKit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TASKS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ADMINS", joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "admin_id", referencedColumnName = "id"))
    private Iterable<Admin> admins;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USERS", joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private Iterable<User> users;
    
    @Column(nullable = false)
    private boolean completed;
    
    @Column(nullable = false)
    private boolean completion_confirmed;
    
    @Column(nullable = false)
    private String task_description;
    
    @Column(nullable = false)
    private Date deadline;
}
