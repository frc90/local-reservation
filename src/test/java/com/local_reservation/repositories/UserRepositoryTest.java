package com.local_reservation.repositories;

import com.local_reservation.models.entities.Local;
import com.local_reservation.models.entities.Reservation;
import com.local_reservation.models.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private LocalRepository localRepository;

    @Test
    public void createUser(){
        Optional<User> existingUser = userRepository.findByEmail("franci1@gmail.com");
        Optional<Local> ifLocal = localRepository.findByName("local 1");
        if (!existingUser.isPresent()) {
            if (!ifLocal.isPresent()) {
                Local local = new Local(
                        null,
                        "local 1",
                        "primer piso",
                        45,
                        true
                );
                localRepository.save(local);
            }
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
                    user,
                    List.of(ifLocal.get())
            );
            reservationRepository.save(reservation);
        } else {
            if (!ifLocal.isPresent()) {
                Local local = new Local(
                        null,
                        "local 1",
                        "primer piso",
                        45,
                        true
                );
                localRepository.save(local);
            }
            Reservation reservation = new Reservation(
                    null,
                    "No 1",
                    "Francisco",
                    LocalDate.of(2020, 10, 10),
                    45,
                    existingUser.get(),
                    List.of(ifLocal.get())
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