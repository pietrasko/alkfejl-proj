/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.csaladitodo.repository;

import hu.elte.alkfejl.csaladitodo.model.Admin;
import hu.elte.alkfejl.csaladitodo.model.Task;
import hu.elte.alkfejl.csaladitodo.model.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author GenQP
 */
public interface TaskRepository extends CrudRepository<Task, Integer>{
    Iterable<Task> findAllByAdmin(Admin admin);
    Iterable<Task> findAllByUser(User user);
}
