package com.local_reservation.repositories;

import com.local_reservation.entities.Reservation;
import com.local_reservation.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    public void createUser(){
        Optional<User> existingUser = userRepository.findByEmail("franci1@gmail.com");
        if (!existingUser.isPresent()) {
            User user = new User(
                    null,
                    "Francisco",
                    "Padron",
                    "franci2@gmail.com",
                    "12345678",
                    new ArrayList<>()
            );
            userRepository.save(user);

            Reservation reservation = new Reservation(
                    null,
                    "No 1",
                    "Francisco",
                    LocalDate.of(2020, 10, 10),
                    45,
                    user
            );
            reservationRepository.save(reservation);
        } else {
            Reservation reservation = new Reservation(
                    null,
                    "No 1",
                    "Francisco",
                    LocalDate.of(2020, 10, 10),
                    45,
                    existingUser.get()
            );
            reservationRepository.save(reservation);
            System.out.println("El usuario con el correo 'franci1@gmail.com' ya existe.");
        }
    }


    @Test
    public void getAllUsers(){
        List<User> users = userRepository.findAll();
        System.out.println("users = " + users);
    }
}