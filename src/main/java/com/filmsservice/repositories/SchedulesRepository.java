package com.filmsservice.repositories;

import com.filmsservice.entities.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SchedulesRepository extends JpaRepository<Schedules, Integer> {

    @Query(value = "select * from schedules where id_schedule = :id", nativeQuery = true)
    Schedules findByScheduleId(@Param("id") Integer fs_fid);

    @Query(value = "select * from schedules where fs_fk = :fs_fk", nativeQuery = true)
    List<Schedules> findSchedulesByFilmId(@Param("fs_fk") Integer fs_fk);

    @Modifying
    @Query(value = "update schedules set fs_fk = :fs_fk where id_schedule = :id", nativeQuery = true)
    Schedules updateFilmIdByScheduleId(@Param("fs_fk") Integer fs_fk,
                             @Param("id") Integer id);

    @Query(value = "select fs_fk from schedules where show_date=:date", nativeQuery = true)
    List<Integer> findSchedulesByDate(@Param("date") LocalDate date);

//    @Modifying
//    @Transactional
//    @Query(value = "update schedules set (show_date, starting_hour, ending_hour, ticket_price, ticket_price, fs_fk) "
//            + "VALUES (:show_date, :starting_hour, :ending_hour, :ticket_price, :ticket_price, :fs_fk) where id_schedule = :id_schedule", nativeQuery = true)
//    void updateSchedules(@Param("id_schedule") Integer idSchedule,
//                         @Param("show_date") LocalDate showDate,
//                         @Param("starting_hour") LocalTime startingHour,
//                         @Param("ending_hour") LocalTime endingHour,
//                         @Param("ticket_price") String ticketPrice,
//                         @Param("ticket_price") String studioName,
//                         @Param("fs_fk") Integer idFilm);
}
