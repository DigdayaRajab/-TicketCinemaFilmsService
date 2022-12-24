package com.filmsservice.controller;

import com.filmsservice.entities.Schedules;
import com.filmsservice.model.CommonResponseGenerator;
import com.filmsservice.model.request.SchedulesRequest;
import com.filmsservice.model.response.ScheduleResponse;
import com.filmsservice.service.Interface.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/schedules")
//@SecurityRequirement(name = "bearerAuth")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    CommonResponseGenerator commonResponseGenerator;


    @Operation(summary = "Endpoint for Add New Schedules")
    @PostMapping(value = "/add", produces = "application/json", consumes = "application/json")
    public ResponseEntity addSchedules(@RequestBody SchedulesRequest schedules) {
        try {
            ScheduleResponse response = scheduleService.addSchedule(schedules);
            return new ResponseEntity(commonResponseGenerator.successResponse( response, "successful add data"), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Created, Error : " + e.getMessage());
            return new ResponseEntity(commonResponseGenerator.failedClientResponse("400", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

//    @Operation(summary = "Endpoint for Update Data Schedules")
//    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
//    public ResponseEntity updateSchedules(@RequestBody SchedulesRequest schedules) {
//        try {
//            ScheduleResponse response = scheduleService.updateSchedule(schedules);
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("content-type","application/json");
//            return ResponseEntity.ok().headers(headers).body(commonResponseGenerator.successResponse( response, "Successful Update Schedules"));
//        } catch (Exception e) {
//            log.error("Update, Error : " + e.getMessage());
//            return new ResponseEntity(commonResponseGenerator.failedClientResponse("400", e.getMessage()), HttpStatus.BAD_REQUEST);
//        }
//    }


    @Operation(summary = "Endpoint for Delete Schedules By Id")
    @DeleteMapping("/delete")
    public ResponseEntity deleteSchedules(@RequestParam("id") int idSchedule) {
        try {
            scheduleService.deleteSchedules(idSchedule);
            return new ResponseEntity(commonResponseGenerator.successResponse("", "successful delete data"), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Delete, Error : " + e.getMessage());
            return new ResponseEntity(commonResponseGenerator.failedClientResponse("400", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }



    @Operation(summary = "Endpoint for Get All Schedules")
    @GetMapping(value = "/getAllSchedules")
    public ResponseEntity getAllSchedules() {
        try {
            List<Schedules> response = scheduleService.findAll();

            HttpHeaders headers = new HttpHeaders();
            headers.add("content-type","application/json");
            return ResponseEntity.ok().headers(headers).body(commonResponseGenerator.successResponse( response, "Successful Get Schedule"));
        } catch (Exception e) {
            log.error("Get All Schedules, Error : " + e.getMessage());
            return new ResponseEntity(commonResponseGenerator.failedClientResponse("400", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @Operation(summary = "Endpoint for Schedules By Id")
    @GetMapping(value = "/getScheduleById")
    public ResponseEntity getScheduleById(@RequestParam("id") int idFilm) {
        try {
            Schedules response = scheduleService.findByScheduleId(idFilm);

            HttpHeaders headers = new HttpHeaders();
            headers.add("content-type","application/json");
            return ResponseEntity.ok().headers(headers).body(commonResponseGenerator.successResponse( response, "Successful Get Schedule By Id"));
        } catch (Exception e) {
            log.error("Get Schedule By Id, Error : " + e.getMessage());
            return new ResponseEntity(commonResponseGenerator.failedClientResponse("400", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @Operation(summary = "Endpoint for Get Schedules By Film Id")
    @GetMapping(value = "/getSchedulesByFilmId")
    public ResponseEntity findSchedulesByFilmId(@RequestParam("id") int idFilm) {
        try {
            List<Schedules> response = scheduleService.findSchedulesByFilmId(idFilm);

            HttpHeaders headers = new HttpHeaders();
            headers.add("content-type","application/json");
            return ResponseEntity.ok().headers(headers).body(commonResponseGenerator.successResponse( response, "Successful Get Schedule By Film Id"));
        } catch (Exception e) {
            log.error("Find Schedules By Film Id, Error : " + e.getMessage());
            return new ResponseEntity(commonResponseGenerator.failedClientResponse("400", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @Operation(summary = "Endpoint for Delete Seat By Id Schedules")
    @DeleteMapping("/seat/deleteByIdSchedules")
    public ResponseEntity deleteByIdSchedules(@RequestParam("id") int idSchedule) {
        try {
            scheduleService.deleteSeatByIdSchedules(idSchedule);
            return new ResponseEntity(commonResponseGenerator.successResponse("", "successful delete data"), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Delete, Error : " + e.getMessage());
            return new ResponseEntity(commonResponseGenerator.failedClientResponse("400", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Endpoint for Delete Seat By Id Schedules")
    @PutMapping("/seat/updateStatusOrdered")
    public ResponseEntity updateStatusOrdered(@RequestParam("noTicket") String noTicket) {
        try {
            scheduleService.updateStatusOrdered(noTicket);
            return new ResponseEntity(commonResponseGenerator.successResponse("", "successful Update Status Ordered data"), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Delete, Error : " + e.getMessage());
            return new ResponseEntity(commonResponseGenerator.failedClientResponse("400", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
