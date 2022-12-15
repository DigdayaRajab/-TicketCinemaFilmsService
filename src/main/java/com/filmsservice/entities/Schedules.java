package com.filmsservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Schedules {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_schedule", nullable = false)
    private Integer idSchedule;

    @Column(nullable = false)
    private String showDate;
    @Column(nullable = false)
    private String startingHour;
    @Column(nullable = false)
    private String endingHour;
    @Column(nullable = false)
    private String ticketPrice;

    @Column(name = "fs_fk")
    private Integer fs_fk;
//    @ManyToOne
//    private Films film;
}
