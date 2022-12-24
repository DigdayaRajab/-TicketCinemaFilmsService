package com.filmsservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FilmUpdate {
    @NonNull
    private Integer idFilm;

    @NonNull
    private String title;

    @NonNull
    private String genres;

    @NonNull
    private String synopsis;

    @NonNull
    private String yearsCategories;

    private String poster;
    private String backPoster;

    private Integer isShow;
}
