package de.dhbw.ravensburg.wp.mymoviedatabase.repository;

import de.dhbw.ravensburg.wp.mymoviedatabase.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitleContaining(String substring);

    List<Movie> findByImdbRatingGreaterThan(double rating);

    @Query("SELECT m FROM Movie m WHERE m.title like %:param1%")
    List<Movie> findAllMoviesBelongingToSeries(@Param("param1") String series);

    @Query("SELECT m FROM Movie m JOIN m.involvedCast c " +
            "WHERE c.surname = :param1")
    List<Movie> findAllMoviesWithCastSurname(@Param("param1") String castSurname);

    @Query("SELECT m FROM Movie m " +
            "WHERE m.soundtrack.author_surname = :param1")
    List<Movie> findAllMoviesWithSoundtrackAuthor(@Param("param1") String castSurname);

    @Query("SELECT m FROM Movie m " +
            "WHERE size(m.involvedCast) > :param1")
    List<Movie> findAllMoviesWithMoreThanGivenCasts(@Param("param1") Integer num);

    @Query("SELECT m FROM Movie m " +
            "JOIN m.awards a WHERE a.academy = :param1")
    List<Movie> findAllMoviesWithAwardAcademy(@Param("param1") String academy);

    @Query("SELECT m FROM Movie m " +
            "JOIN m.awards a WHERE a.category = :param1 " +
            "AND size(m.involvedCast) >= :param2 " +
            "AND m.soundtrack.releaseDate >= :param3 " +
            "AND m.soundtrack.releaseDate <= :param4")
    List<Movie> findMoviesWithAwardCategoryAndReleaseDate(
            @Param("param1") String award,
            @Param("param2") int castSize,
            @Param("param3") LocalDate firstReleaseDate,
            @Param("param4") LocalDate lastReleaseDate
    );
}
