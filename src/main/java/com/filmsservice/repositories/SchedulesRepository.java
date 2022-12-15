package com.filmsservice.repositories;

import com.filmsservice.entities.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SchedulesRepository extends JpaRepository<Schedules, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO schedules (show_date, starting_hour, ending_hour, ticket_price, fs_fk) "
            + "VALUES (:showDate, :startingHour, :endingHour, :ticketPrice, :fs_fk)", nativeQuery = true)
    void saveSchedule(@Param("showDate") String showDate,
                      @Param("startingHour") String startingHour,
                      @Param("endingHour") String endingHour,
                      @Param("ticketPrice") String ticketPrice,
                      @Param("fs_fk") Integer fs_fk);

    @Query(value = "select * from schedules where fs_fk = :fs_fk", nativeQuery = true)
    List<Schedules> findByFilmId(@Param("fs_fk") Integer fs_fk);

    @Query(value = "update schedules set fs_fk = :fs_fk where id_schedule = :id", nativeQuery = true)
    Schedules updateFsFkById(@Param("fs_fk") Integer fs_fk,
                             @Param("id") Integer id);
}
