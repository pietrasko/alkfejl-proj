/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.csaladitodo.repository;

import hu.elte.alkfejl.csaladitodo.model.Admin;
import hu.elte.alkfejl.csaladitodo.model.Task;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author GenQP
 */
public interface AdminRepository extends CrudRepository<Admin, Integer> {
    Optional<Admin> findByUsername(String name);
    Optional<Admin> findByUsernameAndPassword(String name, String password);
    Iterable<Task> findTasksByUsername(String name);
}
