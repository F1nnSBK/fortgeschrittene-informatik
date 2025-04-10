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

    List<Movie> findByPremiereDateGreaterThan(LocalDate premiereDate);

    @Query("SELECT m FROM Movie m WHERE m.title = :param1")
    List<Movie> findAllMoviesByTitle(
            @Param("param1") String title);

    @Query("SELECT m FROM Movie m WHERE m.duration < :param1 AND m.imdbRating > :param2")
    List<Movie> findAllMoviesByDurationAndImdbRating(@Param("param1") double duration, @Param("param2") double imdbRating);
}

