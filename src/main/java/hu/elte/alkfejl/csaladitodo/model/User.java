package hu.elte.alkfejl.csaladitodo.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import utils.Role;

@Entity
@Table(name = "USERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, length=50)
    private String name;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
    
    @OneToMany(targetEntity = Task.class, mappedBy = "user")
    private List<Task> tasks;
    
    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }
    
    public Role getRole() {
        return role;
    }
    
    public int getId(){
        return this.id;
    }
}