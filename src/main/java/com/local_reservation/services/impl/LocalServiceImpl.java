package com.local_reservation.services.impl;

import com.local_reservation.models.entities.Local;

import java.util.List;
import java.util.Optional;

public interface LocalServiceImpl {
    List<Local> getAllLocals();
    Local createLocal(Local local);
    Optional<Local> getLocalById(Long id);
    Optional<Local> updateLocalById(Long id, Local local);
    boolean deleteLocal(Long id);
}
