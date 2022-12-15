package com.filmsservice.service;

import com.filmsservice.entities.Seats;
import com.filmsservice.model.request.SeatStatusRequest;
import com.filmsservice.repositories.SeatsRepository;
import com.filmsservice.service.Interface.SeatsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SeatsServiceImpl implements SeatsService {

    @Autowired
    SeatsRepository seatsRepository;

    @Override
    public Seats newSeats(Seats seat) throws Exception {
        Seats aSeat = seatsRepository.findSeatById(seat.getSeatId().getSeatNo(), seat.getSeatId().getStudioName());
        if (aSeat != null) {
            throw new Exception("Seat Already");
        }

        return seatsRepository.save(seat);
    }

    @Override
    public List<Seats> findAllSeats() {
        return seatsRepository.findAll();
    }

    @Override
    public Seats updateSeats(Seats seat) {
        return seatsRepository.save(seat);
    }

    @Override
    public Seats updateSeatsStatus(SeatStatusRequest seat) throws Exception{
        Seats aSeat = seatsRepository.findSeatById(seat.getSeatNo(), seat.getStudioName());
        if (aSeat == null) {
            throw new Exception("Seat Not Found");
        }

        if (aSeat.getStatus().equals("ordered")){
            throw new Exception("Seat Has Ordered");
        }else {
            aSeat.setStatus("ordered");
        }

        return seatsRepository.save(aSeat);
    }

    @Override
    public void deleteSeats(Seats seat) throws Exception {
        Seats aSeat = seatsRepository.findSeatById(seat.getSeatId().getSeatNo(), seat.getSeatId().getStudioName());
        if (aSeat == null) {
            throw new Exception("Seat Not Found");
        }
        try {
            seatsRepository.deleteSeatById(seat.getSeatId().getSeatNo(), seat.getSeatId().getStudioName());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
