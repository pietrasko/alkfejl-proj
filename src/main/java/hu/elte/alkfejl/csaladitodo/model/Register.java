package hu.elte.alkfejl.csaladitodo.model;

/**
 *
 * @author GenQP
 */
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "REGISTERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(nullable = false)
    private String username;
    
    @Column(nullable = false, length = 11)
    private String code;
}
