package com.whatever.springsecurity.repositories;

import java.util.List;

import com.whatever.springsecurity.models.Role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * RoleRepository
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    List<Role> findAll();
    
    List<Role> findByName(String name);
}