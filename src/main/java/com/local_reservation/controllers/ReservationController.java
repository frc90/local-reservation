package com.local_reservation.controllers;

import com.local_reservation.models.entities.Reservation;
import com.local_reservation.services.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public List<Reservation> getAllReservations(){
        return reservationService.getAllReservations();
    }

    @GetMapping("/reservation/{id}")
    public Optional<Reservation> getReservationById(@PathVariable Long id){
        return reservationService.getReservationById(id);
    }

    @PostMapping("/reservation")
    public Reservation createReservation(@RequestBody Reservation reservation){
        return reservationService.createReservation(reservation);
    }

    @PutMapping("/reservation/{id}")
    public Optional<Reservation> updateReservationById(@PathVariable Long id, Reservation reservation){
        return reservationService.updateReservationById(id, reservation);
    }

    @DeleteMapping("/reservation/{id}")
    public String deleteReservation(@PathVariable Long id){
        if (reservationService.deleteReservation(id)) {
            return "Reservation was delete!";
        }
        return "Sorry was an error!";
    }
}
