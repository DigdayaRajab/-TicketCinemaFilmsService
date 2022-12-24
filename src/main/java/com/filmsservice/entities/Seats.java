package com.filmsservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Seats")
public class Seats {
    @EmbeddedId
    private SeatsId seatId;

    private boolean isOrdered;

    @Column(name = "fs_fsi")
    private Integer fs_fsi;

}

