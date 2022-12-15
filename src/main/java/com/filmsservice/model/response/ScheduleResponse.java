package com.filmsservice.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleResponse {

    private Integer idSchedule;

    @Schema(example = "2022-11-23")
    private String showDate;

    @Schema(example = "12.00")
    private String startingHour;

    @Schema(example = "16.00")
    private String endingHour;

    @Schema(example = "50000")
    private String ticketPrice;

    @Schema(example = "Integer, unique")
    private Integer fsFk;
}
