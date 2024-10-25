package com.local_reservation.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String coordinator;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private int participants;

    @ManyToOne
    @JoinColumn(
            name = "user_id"
    )
    private User user;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "local_reservation",
            joinColumns = @JoinColumn(
                    name = "local_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "reservation_id",
                    referencedColumnName = "id"
            )
    )
    private List<Local> locals;
}
