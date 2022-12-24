package com.filmsservice.schedulers;

import com.filmsservice.service.Interface.FilmService;
import com.filmsservice.service.Interface.ScheduleService;
import com.filmsservice.service.ScheduleServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;

@Component
@Slf4j
public class updateFilmsStatus {

    @Autowired
    FilmService filmService;
    @Autowired
    ScheduleService scheduleService;


//    @Scheduled(cron = "0 0 0 ? * *")  // in one Day
//    @Scheduled(cron = "0 * * ? * *")  // in one minute
    @Scheduled(fixedDelay = 10000)     // in one second
    public void filmShowing() {
        String getDateNow = new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis());

        List<Integer> schedulesAlready = scheduleService.findSchedulesByDate(getDateNow);
        if (!schedulesAlready.isEmpty()) {
            for (int i = 0; i < schedulesAlready.size(); i++) {
                try {
                    filmService.updateFilmStatusShowing(schedulesAlready.get(i));
                } catch (Exception e) {
                    log.error("Error Schedulers Update Showing Film : " + e.getMessage());
                }
            }
        }
    }

}
