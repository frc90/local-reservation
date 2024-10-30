package com.local_reservation.controllers;

import com.local_reservation.models.entities.Local;
import com.local_reservation.repositories.LocalRepository;
import com.local_reservation.services.LocalService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LocalController {
    private final LocalService localService;

    public LocalController(LocalService localService){
        this.localService = localService;
    }



    @GetMapping("/locals")
    public List<Local> getAllLocals(){
        return localService.getAllLocals();
    }

    @GetMapping("/local/{id}")
    public Optional<Local> getLocalById(@PathVariable Long id){
        return localService.getLocalById(id);
    }

    @PostMapping("/local")
    public Local createLocal(@RequestBody Local local){
        return localService.createLocal(local);
    }

    @PutMapping("/local/{id}")
    public Optional<Local> updateLocalById(@PathVariable Long id, @RequestBody Local local){
        return localService.updateLocalById(id, local);
    }

    @DeleteMapping("/local/{id}")
    public String deleteLocal(@PathVariable Long id){
        if (localService.deleteLocal(id)) {
            return "Local was delete!";
        }
        return "Sorry was an error!";
    }
}
