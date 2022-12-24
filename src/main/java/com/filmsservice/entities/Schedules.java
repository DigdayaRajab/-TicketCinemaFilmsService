package com.filmsservice.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Schedules {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_schedule", nullable = false)
    private Integer idSchedule;

    @Column(nullable = false)
    private LocalDate showDate;

    @Column(nullable = false)
    @JsonFormat(pattern = "HH:mm")
    private LocalTime startingHour;

    @Column(nullable = false)
    @JsonFormat(pattern = "HH:mm")
    private LocalTime  endingHour;

    @Column(nullable = false)
    private String ticketPrice;

    @Column(nullable = false)
    private String studioName;

    @Column(name = "fs_fk")
    private Integer fs_fk;

//    @ManyToOne
//    private Films film;

    @OneToMany(targetEntity = Seats.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fs_fsi", referencedColumnName = "id_schedule")
    private List<Seats> seats;

//    @OneToMany(mappedBy="schedules")
//    private List<Seats> seats;
}
