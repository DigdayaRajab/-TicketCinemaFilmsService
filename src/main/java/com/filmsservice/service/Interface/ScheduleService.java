package com.filmsservice.service.Interface;


import com.filmsservice.entities.Schedules;
import com.filmsservice.model.request.SchedulesRequest;
import com.filmsservice.model.response.ScheduleResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScheduleService {
    ScheduleResponse addSchedule(SchedulesRequest schedules);

    ScheduleResponse updateFilm(SchedulesRequest schedules);

    void deleteSchedules(int idSchedule);

    List<Schedules> findAll();

    List<Schedules> findByFilmId(int idFilm);

}
