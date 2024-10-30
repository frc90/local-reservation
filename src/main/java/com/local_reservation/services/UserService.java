package com.local_reservation.services;

import com.local_reservation.models.entities.User;
import com.local_reservation.repositories.UserRepository;
import com.local_reservation.services.impl.UserServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceImpl {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        Optional<User> usr = userRepository.findById(id);
        if (usr.isPresent()) {
            return Optional.of(usr.get());
        }
        return null;
    }

    @Override
    public Optional<User> updateUserById(Long id, User user) {
        Optional<User> usr = userRepository.findById(id);
        if (usr.isPresent()) {
            user.setName(user.getName());
            user.setLastName(user.getLastName());
            user.setReservations(user.getReservations());
            user.setName(user.getName());

            userRepository.save(usr.get());
            return usr;
        }
        return null;
    }

    @Override
    public boolean deleteUser(Long id) {
        Optional<User> usr = userRepository.findById(id);
        if (usr.isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
