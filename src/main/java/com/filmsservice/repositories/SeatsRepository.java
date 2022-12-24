package com.filmsservice.repositories;

import com.filmsservice.entities.Seats;
import com.filmsservice.entities.SeatsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SeatsRepository extends JpaRepository<Seats, SeatsId> {

    @Query(value = "select * from seats where no_ticket=:no_ticket", nativeQuery = true)
    List<Seats> findSeatByTicket(@Param("no_ticket") String noTicket);

    @Query(value = "select * from seats where fs_fsi=:fs_fsi", nativeQuery = true)
    List<Seats> findSeatByTicket(@Param("fs_fsi") Integer idSchedules);

    @Modifying
    @Transactional
    @Query(value = "delete from seats where fs_fsi=:fs_fsi", nativeQuery = true)
    void deleteSeatByIdSchedules(@Param("fs_fsi") Integer idSchedules);

    @Modifying
    @Transactional
    @Query(value = "update seats set is_ordered='true' where no_ticket=:no_ticket", nativeQuery = true)
    void updateStatusOrdered(@Param("no_ticket") String noTicket);
}
