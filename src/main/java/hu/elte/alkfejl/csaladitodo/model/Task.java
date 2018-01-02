package hu.elte.alkfejl.csaladitodo.model;

/**
 *
 * @author GenQP
 */
import java.sql.Date;
import java.util.List;
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
    
    @JoinColumn
    @ManyToOne(targetEntity = Admin.class)
    private Admin admin;
    
    @ManyToMany(targetEntity = User.class)
    @JoinTable(name = "USER_TASK", joinColumns = @JoinColumn(name = "TASK_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"))
    private List<User> users;
    
    @Column(nullable = false)
    private boolean completed;
    
    @Column(nullable = false)
    private boolean completion_confirmed;
    
    @Column(nullable = false)
    private String task_description;
    
    @Column(nullable = false)
    private Date deadline;
}
