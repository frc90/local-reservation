package com.local_reservation.repositories;

import com.local_reservation.models.entities.Local;
import com.local_reservation.models.entities.Reservation;
import com.local_reservation.models.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LocalRepository localRepository;

    @Test
    public void getAllReservation(){
        List<Reservation> reservations = reservationRepository.findAll();
        System.out.println("reservations = " + reservations);
    }

    @Test
    public void createReservation(){
        Optional<User> user = userRepository.findById(2l);
        Optional<Local> local = localRepository.findById(1l);
        Optional<Local> local2 = localRepository.findById(2l);
        Reservation reservation = new Reservation(
                1l,
                "reservacion: local 1",
                "Francy montes",
                LocalDate.of(2020, 10, 10),
                45,
                user.get(),
                List.of(local.get(), local2.get())
        );

        System.out.println("user = " + user);
        System.out.println("local = " + local);
        System.out.println("local2 = " + local2);
        System.out.println("reservation = " + reservation);

        reservationRepository.save(reservation);
    }
}