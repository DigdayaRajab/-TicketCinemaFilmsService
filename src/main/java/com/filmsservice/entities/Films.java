package com.filmsservice.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
public class Films {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_film", nullable = false)
    private Integer idFilm;

    @Column(nullable = false)
    private String title;
    private String genres;

    @Column(columnDefinition = "TEXT")
    private String synopsis;

    private String yearsCategories;
    private String poster;
    private String backPoster;

    private boolean isShow;

    @OneToMany(targetEntity = Schedules.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fs_fk", referencedColumnName = "id_film")
    private List<Schedules> schedules;
}
