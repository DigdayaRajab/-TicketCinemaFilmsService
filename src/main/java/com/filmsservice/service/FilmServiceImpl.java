package com.filmsservice.service;

import com.filmsservice.entities.Films;
import com.filmsservice.model.dto.FilmUpdate;
import com.filmsservice.model.request.FilmUpdateRequest;
import com.filmsservice.model.response.FilmScheduleResponse;
import com.filmsservice.repositories.FilmRepository;
import com.filmsservice.service.Interface.FilmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    FilmRepository filmRepository;

    @Override
    public Films save(Films films) {
        return filmRepository.save(films);
    }

    @Override
    public FilmUpdate updateFilm(FilmUpdateRequest filmUpdateRequest) throws Exception {

        Films filmAlready = filmRepository.findFilmsById(filmUpdateRequest.getFilmUpdate().getIdFilm());
        if (filmAlready == null) {
            throw new Exception("Film Not Found");
        }

        Integer idFilm = filmUpdateRequest.getFilmUpdate().getIdFilm();
        String title = filmUpdateRequest.getFilmUpdate().getTitle();
        String genres = filmUpdateRequest.getFilmUpdate().getGenres();
        String synopsis = filmUpdateRequest.getFilmUpdate().getSynopsis();
        String yearsCategories = filmUpdateRequest.getFilmUpdate().getYearsCategories();
        String poster = filmUpdateRequest.getFilmUpdate().getPoster();
        String backPoster = filmUpdateRequest.getFilmUpdate().getBackPoster();
        boolean isShow = filmUpdateRequest.getFilmUpdate().getIsShow() != 0;

        try {
            filmRepository.update(title, genres, synopsis, yearsCategories, poster, backPoster, isShow, idFilm);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }

        FilmUpdate FilmResponse = new FilmUpdate();
        FilmResponse.setIdFilm(idFilm);
        FilmResponse.setTitle(title);
        FilmResponse.setGenres(genres);
        FilmResponse.setSynopsis(synopsis);
        FilmResponse.setYearsCategories(yearsCategories);
        FilmResponse.setPoster(poster);
        FilmResponse.setBackPoster(backPoster);
        FilmResponse.setIsShow((!isShow) ? 0 : 1);

        return FilmResponse;
    }

    @Override
    public void deleteById(int idFilm) {
        filmRepository.deleteById(idFilm);
    }

    @Override
    public List<Films> findAll() {
        return filmRepository.findAll();
    }


    @Override
    public Films findFilmsById(Integer idFilm) throws Exception {
        Films filmResponse = filmRepository.findFilmsById(idFilm);
        if (filmResponse == null) {
            throw new Exception("Film Not Found");
        }
        return filmResponse;
    }

    @Override
    public void updateFilmStatusShowing(Integer idFilm) throws Exception {
        Films filmResponse = filmRepository.findFilmsById(idFilm);
        if (filmResponse == null) {
            throw new Exception("Film Not Found");
        }

        try {
            filmRepository.updateStatusShowingTrue(idFilm);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void resetFilmStatusShowing(Integer idFilm) {
        Films filmResponse = filmRepository.findFilmsById(idFilm);
        if (filmResponse == null) {
             log.info("Film id Not Found");
        }

        try {
            filmRepository.resetStatusShowing(idFilm);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    @Override
    public List<Films> findFilmsShow() throws Exception {
        List<Films> filmResponse = filmRepository.findFilmsShow();
        if (filmResponse == null || filmResponse.isEmpty()) {
            throw new Exception("Films Showing Not Found");
        }

        return filmResponse;
    }

    @Override
    public List<Films> findFilmsByName(String title) throws Exception {
        List<Films> filmResponse = filmRepository.findFilmsByName(title);
        if (filmResponse == null || filmResponse.isEmpty()) {
            throw new Exception("Films Name Not Found");
        }
        return filmResponse;
    }

}
