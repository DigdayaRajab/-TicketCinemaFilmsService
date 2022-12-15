package com.filmsservice.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchedulesRequest {
    private Integer idSchedule;
    @NonNull
    private String showDate;
    @NonNull
    private String startingHour;
    @NonNull
    private String endingHour;
    @NonNull
    private String ticketPrice;
    @NonNull
    private Integer codeFilm;
}
