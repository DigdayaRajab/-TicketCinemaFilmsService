package com.filmsservice.service.Interface;


import com.filmsservice.entities.Schedules;
import com.filmsservice.model.request.SchedulesRequest;
import com.filmsservice.model.response.ScheduleResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScheduleService {
    ScheduleResponse addSchedule(SchedulesRequest schedules) throws Exception ;

    void updateStatusOrdered(String idSchedule) throws Exception;

//    ScheduleResponse updateSchedule(SchedulesRequest schedules) throws Exception;

    void deleteSchedules(int idSchedule) throws Exception;

    List<Schedules> findAll();

    Schedules findByScheduleId(int idSchedule) throws Exception;

    List<Schedules> findSchedulesByFilmId(int idFilm) throws Exception;

    void deleteSeatByIdSchedules(int idSchedule) throws Exception;

    List<Integer> findSchedulesByDate(String date);
}
