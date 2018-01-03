package hu.elte.alkfejl.csaladitodo.model;

/**
 *
 * @author GenQP
 */
import java.sql.Date;
import javax.persistence.*;
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
    
    @ManyToOne(targetEntity = User.class)
    private User user;
    
    @Column(nullable = false)
    private boolean completed;
    
    @Column(nullable = false)
    private boolean completion_confirmed;
    
    @Column(nullable = false)
    private String task_description;
    
    @Column(nullable = false)
    private Date deadline;
}
