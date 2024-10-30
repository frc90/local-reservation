package com.local_reservation.services;

import com.local_reservation.models.entities.Reservation;
import com.local_reservation.repositories.ReservationRepository;
import com.local_reservation.services.impl.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService implements ReservationServiceImpl {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Optional<Reservation> getReservationById(Long id) {
        Optional<Reservation> res = reservationRepository.findById(id);
        if (!res.isPresent()) {
            return null;
        }
        return res;
    }

    @Override
    public Optional<Reservation> updateReservationById(Long id, Reservation reservation) {
        Optional<Reservation> res = reservationRepository.findById(id);
        if (!res.isPresent()) {
            res.get().setName(reservation.getName());
            res.get().setDate(reservation.getDate());
            res.get().setCoordinator(reservation.getCoordinator());
            res.get().setParticipants(reservation.getParticipants());
            res.get().setUser(reservation.getUser());
            res.get().setLocals(reservation.getLocals());
            reservationRepository.save(res.get());
            return res;
        }
        return null;
    }

    @Override
    public boolean deleteReservation(Long id) {
        Optional<Reservation> res = reservationRepository.findById(id);
        if (res.isPresent()) {
            reservationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
