package com.filmsservice.service.Interface;

import com.filmsservice.entities.Films;
import com.filmsservice.model.request.FilmUpdateRequest;
import com.filmsservice.model.response.FilmScheduleResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FilmService {


    Films save(Films films);

    FilmUpdateRequest updateFilm(FilmUpdateRequest filmUpdateRequest) throws Exception;

    void deleteById(int idFilm);

    List<Films> findAll();

    List<Films> findFilmsShow() throws Exception;

    List<FilmScheduleResponse> findFilmsScheduleByName(String filmName) throws Exception;

    Films findFilmsById(Integer idFilm) throws Exception;
}
