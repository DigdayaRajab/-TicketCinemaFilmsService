package com.filmsservice.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleResponse {

    private Integer idSchedule;

    private LocalDate showDate;

    private LocalTime startingHour;

    private LocalTime endingHour;

    private String ticketPrice;

    private String studioName;

    private Integer fsFk;

}
