package com.whatever.authentication.repositories;

import java.util.List;

import com.whatever.authentication.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    List<User> findAll();
    // this method finds languages with descriptions containing the search string

    User findByEmail(String email);
}