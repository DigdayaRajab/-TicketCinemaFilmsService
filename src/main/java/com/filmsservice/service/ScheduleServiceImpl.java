package com.filmsservice.service;


import com.filmsservice.entities.Films;
import com.filmsservice.entities.Schedules;
import com.filmsservice.entities.Seats;
import com.filmsservice.entities.SeatsId;
import com.filmsservice.model.request.SchedulesRequest;
import com.filmsservice.model.response.ScheduleResponse;
import com.filmsservice.repositories.FilmRepository;
import com.filmsservice.repositories.SchedulesRepository;
import com.filmsservice.repositories.SeatsRepository;
import com.filmsservice.service.Interface.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    SchedulesRepository schedulesRepository;

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    SeatsRepository seatsRepository;


    @Override
    public ScheduleResponse addSchedule(SchedulesRequest schedulesRequest) throws Exception {
        Films filmResponse = filmRepository.findFilmsById(schedulesRequest.getCodeFilm());
        if (filmResponse == null) {
            throw new Exception("Film Not Found");
        }

        Integer idSchedule = schedulesRequest.getIdSchedule();
        LocalDate showDate = schedulesRequest.getShowDate();
        LocalTime startingHour = schedulesRequest.getStartingHour();
        LocalTime endingHour = schedulesRequest.getEndingHour();
        String ticketPrice = schedulesRequest.getTicketPrice();
        String studioName = schedulesRequest.getStudioName();
        Integer idFilm = schedulesRequest.getCodeFilm();

        String dateTicket = showDate.toString().replace("-", "");
        String startHourTicket = startingHour.toString().replace(":" , "");
        String studioNameTicket = studioName.replace(" ", "");

        String ticketChecked = studioNameTicket + "-" + dateTicket + "-" + startingHour + 1 + "A";
        List<Seats> seatsAlready = seatsRepository.findSeatByTicket(ticketChecked);
        if (!seatsAlready.isEmpty()) {
            throw new Exception("Seats Schedules is Available");
        }

        List<Seats> seatsList = new ArrayList<>();
        if (schedulesRequest.getSeatAdd().getRowA() != null) {
            for (int i = 1; i <= schedulesRequest.getSeatAdd().getRowA(); i++) {
                seatsList.add(addSeat(i, 'A', studioNameTicket, dateTicket, startHourTicket));
            }
        }
        if (schedulesRequest.getSeatAdd().getRowB() != null) {
            for (int i = 1; i <= schedulesRequest.getSeatAdd().getRowB(); i++) {
                seatsList.add(addSeat(i, 'B', studioNameTicket, dateTicket, startHourTicket));
            }
        }
        if (schedulesRequest.getSeatAdd().getRowC() != null) {
            for (int i = 1; i <= schedulesRequest.getSeatAdd().getRowC(); i++) {
                seatsList.add(addSeat(i, 'C', studioNameTicket, dateTicket, startHourTicket));
            }
        }
        if (schedulesRequest.getSeatAdd().getRowD() != null) {
            for (int i = 1; i <= schedulesRequest.getSeatAdd().getRowD(); i++) {
                seatsList.add(addSeat(i, 'D', studioNameTicket, dateTicket, startHourTicket));
            }
        }
        if (schedulesRequest.getSeatAdd().getRowE() != null) {
            for (int i = 1; i <= schedulesRequest.getSeatAdd().getRowE(); i++) {
                seatsList.add(addSeat(i, 'E', studioNameTicket, dateTicket, startHourTicket));
            }
        }

        Schedules schedule = new Schedules();
        schedule.setIdSchedule(0);
        schedule.setShowDate(showDate);
        schedule.setStartingHour(startingHour);
        schedule.setEndingHour(endingHour);
        schedule.setTicketPrice(ticketPrice);
        schedule.setStudioName(studioName);
        schedule.setFs_fk(idFilm);
        schedule.setSeats(seatsList);

        schedulesRepository.save(schedule);

        ScheduleResponse scheduleResponse = new ScheduleResponse();
        scheduleResponse.setIdSchedule(idSchedule);
        scheduleResponse.setShowDate(showDate);
        scheduleResponse.setStartingHour(startingHour);
        scheduleResponse.setEndingHour(endingHour);
        scheduleResponse.setTicketPrice(ticketPrice);
        scheduleResponse.setStudioName(studioName);
        scheduleResponse.setFsFk(idFilm);

        return scheduleResponse;
    }

    private Seats addSeat(int i, char row, String studioNameTicket, String dateTicket, String startHourTicket) {
        Seats seats = new Seats();
        SeatsId seatsId = new SeatsId();

        seatsId.setSeatNo(i);
        seatsId.setSeatRow(row);
        seatsId.setNoTicket(studioNameTicket + "-" + dateTicket + "-" + startHourTicket + i + row);
        seats.setSeatId(seatsId);
        seats.setOrdered(false);

        return seats;
    }

    @Override
    public void deleteSeatByIdSchedules(int idSchedule) throws Exception {
        List<Seats> seatsAlready = seatsRepository.findSeatByTicket(idSchedule);
        if (seatsAlready == null) {
            throw new Exception("Seats Schedules is Not Available");
        }
        seatsRepository.deleteSeatByIdSchedules(idSchedule);
    }
    @Override
    public void updateStatusOrdered(String idSchedule) throws Exception {
        List<Seats> seatsAlready = seatsRepository.findSeatByTicket(idSchedule);
        if (seatsAlready == null) {
            throw new Exception("Seats Schedules is Not Available");
        }
        seatsRepository.updateStatusOrdered(idSchedule);
    }


//    @Override
//    public ScheduleResponse updateSchedule(Schedules Request schedulesRequest) throws Exception {
//    }

    @Override
    public void deleteSchedules(int idSchedule) throws Exception {
        Schedules scheduleAlready = schedulesRepository.findByScheduleId(idSchedule);
        if (scheduleAlready == null) {
            throw new Exception("Schedules Not Found");
        }

        schedulesRepository.deleteById(idSchedule);
    }

    @Override
    public List<Schedules> findAll() {
        return schedulesRepository.findAll();
    }

    @Override
    public Schedules findByScheduleId(int idSchedule) throws Exception {
        Schedules scheduleResponse = schedulesRepository.findByScheduleId(idSchedule);
        if (scheduleResponse == null) {
            throw new Exception("Schedules Not Found");
        }

        return scheduleResponse;
    }

    @Override
    public List<Schedules> findSchedulesByFilmId(int idFilm) throws Exception {
        Films filmResponse = filmRepository.findFilmsById(idFilm);
        if (filmResponse == null) {
            throw new Exception("Schedules Film Not Found");
        }

        List<Schedules> scheduleResponse = schedulesRepository.findSchedulesByFilmId(idFilm);
        if (scheduleResponse == null || scheduleResponse.isEmpty()) {
            throw new Exception("Schedules Film Not Found");
        }

        return scheduleResponse;
    }

    @Override
    public List<Integer> findSchedulesByDate(String date){
        LocalDate localDate = LocalDate.parse(date);

        return schedulesRepository.findSchedulesByDate(localDate);
    }
}
