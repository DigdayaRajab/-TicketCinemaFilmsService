package com.filmsservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Films {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_film", nullable = false)
    private Integer idFilm;

    @Column
    private String filmCode;
    @Column(nullable = false)
    private String filmName;
    @Column(nullable = false)
    private String isShow;

    @OneToMany(targetEntity = Schedules.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fs_fk", referencedColumnName = "id_film")
    private List<Schedules> schedules;
}
