package hu.elte.alkfejl.csaladitodo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.Random;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

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
    
    @OneToMany(targetEntity = Task.class, mappedBy = "user")
    @JsonIgnore
    private List<Task> tasks;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    
    public enum Role {
        GUEST, USER, ADMIN
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