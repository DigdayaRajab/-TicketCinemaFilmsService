package com.filmsservice.service;


import com.filmsservice.entities.Schedules;
import com.filmsservice.model.request.SchedulesRequest;
import com.filmsservice.model.response.ScheduleResponse;
import com.filmsservice.repositories.SchedulesRepository;
import com.filmsservice.service.Interface.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    SchedulesRepository schedulesRepository;

    @Override
    public ScheduleResponse addSchedule(SchedulesRequest schedulesRequest) {
        Schedules schedule = new Schedules();
        schedule.setIdSchedule(0);
        schedule.setShowDate(schedulesRequest.getShowDate());
        schedule.setStartingHour(schedulesRequest.getStartingHour());
        schedule.setEndingHour(schedulesRequest.getEndingHour());
        schedule.setTicketPrice(schedulesRequest.getTicketPrice());
        schedule.setFs_fk(schedulesRequest.getCodeFilm());

        schedulesRepository.save(schedule);

        ScheduleResponse scheduleResponse = new ScheduleResponse();
        scheduleResponse.setIdSchedule(schedule.getIdSchedule());
        scheduleResponse.setShowDate(schedulesRequest.getShowDate());
        scheduleResponse.setStartingHour(schedulesRequest.getStartingHour());
        scheduleResponse.setEndingHour(schedulesRequest.getEndingHour());
        scheduleResponse.setTicketPrice(schedulesRequest.getTicketPrice());
        scheduleResponse.setFsFk(schedulesRequest.getCodeFilm());

        return scheduleResponse;
    }


    @Override
    public ScheduleResponse updateFilm(SchedulesRequest schedulesRequest) {
        Schedules schedule = new Schedules();
        schedule.setIdSchedule(schedulesRequest.getIdSchedule());
        schedule.setShowDate(schedulesRequest.getShowDate());
        schedule.setStartingHour(schedulesRequest.getStartingHour());
        schedule.setEndingHour(schedulesRequest.getEndingHour());
        schedule.setTicketPrice(schedulesRequest.getTicketPrice());
        schedule.setFs_fk(schedulesRequest.getCodeFilm());

        schedulesRepository.save(schedule);

        ScheduleResponse scheduleResponse = new ScheduleResponse();
        scheduleResponse.setIdSchedule(schedule.getIdSchedule());
        scheduleResponse.setShowDate(schedulesRequest.getShowDate());
        scheduleResponse.setStartingHour(schedulesRequest.getStartingHour());
        scheduleResponse.setEndingHour(schedulesRequest.getEndingHour());
        scheduleResponse.setTicketPrice(schedulesRequest.getTicketPrice());
        scheduleResponse.setFsFk(schedulesRequest.getCodeFilm());

        return scheduleResponse;
    }

    @Override
    public void deleteSchedules(int idSchedule) {
        schedulesRepository.deleteById(idSchedule);
    }

    @Override
    public List<Schedules> findAll() {
        return schedulesRepository.findAll();
    }

    @Override
    public List<Schedules> findByFilmId(int idFilm) {
        return schedulesRepository.findByFilmId(idFilm);
    }



}
