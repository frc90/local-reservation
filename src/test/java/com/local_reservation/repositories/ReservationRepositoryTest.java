package com.local_reservation.repositories;

import com.local_reservation.entities.Reservation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    public void getAllReservation(){
        List<Reservation> reservations = reservationRepository.findAll();
        System.out.println("reservations = " + reservations);
    }
}