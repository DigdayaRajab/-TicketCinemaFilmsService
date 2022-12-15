package com.filmsservice.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatStatusRequest {
    @NonNull
    private Character studioName;
    @NonNull
    private Integer seatNo;
}
