package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

//    @Query(value = "SELECT id, email FROM user_data", nativeQuery = true)
//    Iterable<User> findUsers();

    @Query(value = "SELECT * FROM user_data WHERE id = :id", nativeQuery = true)
    User findById (long id);
}
