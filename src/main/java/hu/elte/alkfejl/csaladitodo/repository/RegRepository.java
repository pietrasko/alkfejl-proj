package hu.elte.alkfejl.csaladitodo.repository;

import hu.elte.alkfejl.csaladitodo.model.Registration;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author GenQP
 */
public interface RegRepository extends CrudRepository<Registration, Integer>{
    Optional<Registration> findByName(String name);
}
