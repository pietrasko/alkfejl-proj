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
@Table(name = "TASKS")
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
    
    public void setUser(User user){
        this.user = user;
    }
    
    public void setCompletion(boolean isComplete){
        completed = isComplete;
    }
    
    public void setConfirmed(boolean isConfirmed){
        completion_confirmed = isConfirmed;
    }
    
    public void setTask(String task){
        task_description = task;
    }
    
    public void setDeadline(Timestamp time){
        deadline = time;
    }
    
    public boolean isComplete(){
        return completed;
    }
    
    public boolean isConfirmed(){
        return completion_confirmed;
    }
    
    public int getId(){
        return id;
    }
}
