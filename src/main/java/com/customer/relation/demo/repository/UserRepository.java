package com.customer.relation.demo.repository;


import com.customer.relation.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    // You can add more custom queries as needed, like:
    // Optional<User> findByEmail(String email);
}
