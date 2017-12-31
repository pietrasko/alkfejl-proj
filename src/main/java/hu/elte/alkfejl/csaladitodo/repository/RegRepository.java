package hu.elte.alkfejl.csaladitodo.repository;

import hu.elte.alkfejl.csaladitodo.model.Register;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author GenQP
 */
public interface RegRepository extends CrudRepository<Register, Integer>{
    Optional<Register> findByUsername(String username);
}
