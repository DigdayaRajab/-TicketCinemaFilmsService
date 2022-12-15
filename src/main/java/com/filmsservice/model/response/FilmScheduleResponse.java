package com.filmsservice.model.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmScheduleResponse {
    private String filmName;
    private String isShow;

    private String showDate;
    private String startingHour;
    private String endingHour;
    private String ticketPrice;
}
