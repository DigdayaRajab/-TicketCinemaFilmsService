package com.filmsservice.schedulers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class updateFilmsStatus {

    @Scheduled(cron = "0 0 0 ? * *")
//    @Scheduled(cron = "0 * * ? * *")
//    @Scheduled(fixedDelay = 1000)
    public void filmShowing(){
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Task Test on : " + fmt.format(System.currentTimeMillis()));
    }
}
