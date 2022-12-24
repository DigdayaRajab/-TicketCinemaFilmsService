package com.filmsservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SeatAdd {

    private Integer rowA;
    private Integer rowB;
    private Integer rowC;
    private Integer rowD;
    private Integer rowE;
}
