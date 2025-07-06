package com.customer.relation.demo.service;




import com.customer.relation.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(Integer id);

    Optional<User> getUserByUsername(String username);

    void deleteUser(Integer id);
}
