package com.filmsservice.model.request;

import com.filmsservice.model.dto.SeatAdd;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchedulesRequest {
    private Integer idSchedule;

    @NonNull
    private LocalDate showDate;

    @NonNull
    private LocalTime startingHour;

    @NonNull
    private LocalTime endingHour;

    @NonNull
    private String ticketPrice;

    @NonNull
    private String studioName;

    @NonNull
    private Integer codeFilm;

    private SeatAdd seatAdd;
}
