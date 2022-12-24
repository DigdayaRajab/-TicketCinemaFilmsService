package com.filmsservice.controller;

import com.filmsservice.entities.Films;
import com.filmsservice.model.CommonResponseGenerator;
import com.filmsservice.model.dto.FilmUpdate;
import com.filmsservice.model.request.FilmRequest;
import com.filmsservice.model.request.FilmUpdateRequest;
import com.filmsservice.service.Interface.FilmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/film")
//@SecurityRequirement(name = "bearerAuth")
public class FilmController {
    @Autowired
    private FilmService filmService;
    @Autowired
    CommonResponseGenerator commonResponseGenerator;


    @Operation(summary = "Endpoint for Add New Film")
    @PostMapping(value = "/add", produces = "application/json", consumes = "application/json")
    public ResponseEntity addFilm(@NonNull @RequestBody FilmRequest request) {
        try {
            Films response = filmService.save(request.getFilms());
            return new ResponseEntity(commonResponseGenerator.successResponse( response, "successful add data"), HttpStatus.OK);
       } catch (Exception e) {
            log.error("Add, Error : " + e.getMessage());
            return new ResponseEntity(commonResponseGenerator.failedClientResponse("400", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Endpoint for Update Film")
    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    public ResponseEntity updateFilm(@RequestBody FilmUpdateRequest paramUser) {
        try {
            FilmUpdate response = filmService.updateFilm(paramUser);
            HttpHeaders headers = new HttpHeaders();
            headers.add("content-type","application/json");
            return ResponseEntity.ok().headers(headers).body(commonResponseGenerator.successResponse( response, "successful update data"));
        } catch (Exception e) {
            log.error("Update, Error : " + e.getMessage());
            return new ResponseEntity(commonResponseGenerator.failedClientResponse("400", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Endpoint for Get Film by Id")
    @GetMapping(value = "/getFilmById")
    public ResponseEntity getFilmById(@RequestParam("id_film") int idFilm) {
        try {
            Films response = filmService.findFilmsById(idFilm);
            HttpHeaders headers = new HttpHeaders();
            headers.add("content-type","application/json");
            return ResponseEntity.ok().headers(headers).body(commonResponseGenerator.successResponse( response, "successful get data"));
        } catch (Exception e) {
            log.error("Get Film by Id, Error : " + e.getMessage());
            return new ResponseEntity(commonResponseGenerator.failedClientResponse("400", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    @Operation(summary = "Endpoint for Deleted Film by Id")
    @DeleteMapping("/delete")
    public ResponseEntity deleteFilm(@RequestParam("id_film") int idFilm) {
        try {
            filmService.deleteById(idFilm);
            return new ResponseEntity(commonResponseGenerator.successResponse( "", "successful delete data"), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Delete, Error : " + e.getMessage());
            return new ResponseEntity(commonResponseGenerator.failedClientResponse("400", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Endpoint for Get All Film")
    @GetMapping(value = "/getAllFilms")
    public ResponseEntity findAllFilms() {
        try {
            List<Films> response = filmService.findAll();

            HttpHeaders headers = new HttpHeaders();
            headers.add("content-type","application/json");
            return ResponseEntity.ok().headers(headers).body(commonResponseGenerator.successResponse( response, "Successful Get All Film"));
        } catch (Exception e) {
            log.error("Get All, Error : " + e.getMessage());
            return new ResponseEntity(commonResponseGenerator.failedClientResponse("400", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @Operation(summary = "Endpoint for Get All Film Show")
    @GetMapping(value = "/getFilmsShow")
    public ResponseEntity findFilmsShow() {
        try {
            List<Films> response = filmService.findFilmsShow();

            HttpHeaders headers = new HttpHeaders();
            headers.add("content-type","application/json");
            return ResponseEntity.ok().headers(headers).body(commonResponseGenerator.successResponse( response, "Successful Get Film Showing"));
        } catch (Exception e) {
            log.error("Get Film Show, Error : " + e.getMessage());
            return new ResponseEntity(commonResponseGenerator.failedClientResponse("400", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Endpoint for Get Film By Name")
    @GetMapping(value = "/getFilmsByName")
    public ResponseEntity findFilmsByName(@RequestParam("title") String title) {
        try {
            List<Films> response = filmService.findFilmsByName(title);

            HttpHeaders headers = new HttpHeaders();
            headers.add("content-type","application/json");
            return ResponseEntity.ok().headers(headers).body(commonResponseGenerator.successResponse( response, "Successful Get Film By Name"));
        } catch (Exception e) {
            log.error("Get Schedule By Name, Error : " + e.getMessage());
            return new ResponseEntity(commonResponseGenerator.failedClientResponse("400", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @Operation(summary = "Endpoint for Update Film Status Showing")
    @PutMapping(value = "/updateFilmShowing")
    public ResponseEntity updateFilmShowing(@RequestParam("id_film") int idFilm) {
        try {
            filmService.updateFilmStatusShowing(idFilm);
            return new ResponseEntity(commonResponseGenerator.successResponse( "", "Successful update Status show"), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Update, Error : " + e.getMessage());
            return new ResponseEntity(commonResponseGenerator.failedClientResponse("400", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
