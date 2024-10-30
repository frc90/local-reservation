package com.local_reservation.services.impl;

import com.local_reservation.models.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceImpl {
    List<User> getAllUsers();
    User createUser(User user);
    Optional<User> getUserById(Long id);
    Optional<User> updateUserById(Long id, User user);
    boolean deleteUser(Long id);
}
