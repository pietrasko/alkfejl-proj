package hu.elte.alkfejl.csaladitodo.repository;

import hu.elte.alkfejl.csaladitodo.model.Task;
import hu.elte.alkfejl.csaladitodo.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author GenQP
 */
public interface TaskRepository extends CrudRepository<Task, Integer>{
    Iterable<Task> findByUser(User user);
}
