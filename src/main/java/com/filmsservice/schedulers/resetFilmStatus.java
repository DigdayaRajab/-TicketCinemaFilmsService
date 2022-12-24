package com.filmsservice.schedulers;

import com.filmsservice.service.Interface.FilmService;
import com.filmsservice.service.Interface.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.List;

@Slf4j
public class resetFilmStatus implements Job {

    @Autowired
    FilmService filmService;
    @Autowired
    ScheduleService scheduleService;


    //    Reset / Update Film Status Showing 'false' on 23.40, every day
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String getDateNow = new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis());

        List<Integer> schedulesAlready = scheduleService.findSchedulesByDate(getDateNow);
        if (!schedulesAlready.isEmpty()) {
            for (int i = 0; i < schedulesAlready.size(); i++) {
                try {
                    filmService.resetFilmStatusShowing(schedulesAlready.get(i));
                } catch (Exception e) {
                    log.error("Error Schedulers Update Showing Film : " + e.getMessage());
                }
            }
        }
    }
}

