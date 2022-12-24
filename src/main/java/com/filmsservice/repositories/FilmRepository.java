package com.filmsservice.repositories;

import com.filmsservice.entities.Films;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Films, Integer> {

    @Query(value = "select * from films where id_film = :id_film", nativeQuery = true)
    Films findFilmsById(@Param("id_film") Integer id_film);

    @Modifying
    @Transactional
    @Query(value = "update films set " +
            "title= :title, " +
            "genres=:genres, " +
            "synopsis=:synopsis, " +
            "years_categories=:years_categories, " +
            "poster=:poster, " +
            "is_show=:is_show, " +
            "back_poster=:back_poster " +
            "where id_film = :id_film", nativeQuery = true)
    void update(@Param("title") String title,
                @Param("genres") String genres,
                @Param("synopsis") String synopsis,
                @Param("years_categories") String years_categories,
                @Param("poster") String poster,
                @Param("back_poster") String back_poster,
                @Param("is_show") Boolean is_show,
                @Param("id_film") Integer id_film);

    @Modifying
    @Transactional
    @Query(value = "update films set is_show='true' where id_film = :id_film", nativeQuery = true)
    void updateStatusShowingTrue(@Param("id_film") Integer idFilm);

    @Modifying
    @Transactional
    @Query(value = "update films set is_show='false' where id_film = :id_film", nativeQuery = true)
    void resetStatusShowing(@Param("id_film") Integer idFilm);

    @Query(value = "select * from films where is_show = true", nativeQuery = true)
    List<Films> findFilmsShow();


    @Query(value = "select * from films where title like %:title%", nativeQuery = true)
    List<Films> findFilmsByName(@Param("title") String title);

}
