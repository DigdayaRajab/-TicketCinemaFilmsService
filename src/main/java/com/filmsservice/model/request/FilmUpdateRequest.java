package com.filmsservice.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FilmUpdateRequest {
    @NonNull
    private Integer idFilm;
    @NonNull
    private String filmCode;
    @NonNull
    private String filmName;
    @NonNull
    private String isShow;
}
