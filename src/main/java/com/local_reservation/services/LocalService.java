package com.local_reservation.services;

import com.local_reservation.models.entities.Local;
import com.local_reservation.repositories.LocalRepository;
import com.local_reservation.services.impl.LocalServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalService implements LocalServiceImpl {

    private final LocalRepository localRepository;

    public LocalService(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    @Override
    public List<Local> getAllLocals() {
        return localRepository.findAll();
    }

    @Override
    public Local createLocal(Local local) {
        return localRepository.save(local);
    }

    @Override
    public Optional<Local> getLocalById(Long id) {
        Optional<Local> lcl = Optional.of(localRepository.findById(id).get());
        if (!lcl.isPresent()) {
            return null;
        }
        return lcl;
    }

    @Override
    public Optional<Local> updateLocalById(Long id, Local local) {
        Optional<Local> lcl = Optional.of(localRepository.findById(id).get());
        if (lcl.isPresent()) {
            lcl.get().setName(local.getName());
            lcl.get().setLocation(local.getLocation());
            lcl.get().setCapacity(local.getCapacity());
            lcl.get().setAvailability(local.isAvailability());
            localRepository.save(lcl.get());
            return lcl;
        }
        return null;
    }

    @Override
    public boolean deleteLocal(Long id) {
        Optional<Local> lcl = Optional.of(localRepository.findById(id).get());
        if (lcl.isPresent()) {
            localRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
