package com.filmsservice.service.Interface;

import com.filmsservice.entities.Films;
import com.filmsservice.model.dto.FilmUpdate;
import com.filmsservice.model.request.FilmUpdateRequest;
import com.filmsservice.model.response.FilmScheduleResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FilmService {


    Films save(Films films);

    FilmUpdate updateFilm(FilmUpdateRequest filmUpdateRequest) throws Exception;

    void deleteById(int idFilm);

    List<Films> findAll();


    Films findFilmsById(Integer idFilm) throws Exception;

    List<Films> findFilmsShow() throws Exception;

    List<Films> findFilmsByName(String filmName) throws Exception;

    void updateFilmStatusShowing(Integer idFilm) throws Exception;

    void resetFilmStatusShowing(Integer idFilm);
}
