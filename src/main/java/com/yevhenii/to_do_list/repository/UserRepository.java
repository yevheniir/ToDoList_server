package com.yevhenii.to_do_list.repository;

import com.yevhenii.to_do_list.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.email=?1")
    Optional<User> findByEmail(String email);
}