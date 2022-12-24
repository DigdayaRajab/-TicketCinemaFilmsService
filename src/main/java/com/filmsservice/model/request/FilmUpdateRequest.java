package com.filmsservice.model.request;

import com.filmsservice.model.dto.FilmUpdate;
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
    private FilmUpdate filmUpdate;
}
