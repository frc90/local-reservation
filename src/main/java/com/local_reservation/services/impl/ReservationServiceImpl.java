package com.local_reservation.services.impl;

import com.local_reservation.models.entities.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationServiceImpl {
    List<Reservation> getAllReservations();
    Reservation createReservation(Reservation reservation);
    Optional<Reservation> getReservationById(Long id);
    Optional<Reservation> updateReservationById(Long id, Reservation reservation);
    boolean deleteReservation(Long id);
}
