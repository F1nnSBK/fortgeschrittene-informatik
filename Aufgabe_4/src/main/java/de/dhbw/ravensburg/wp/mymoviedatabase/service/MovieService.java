package de.dhbw.ravensburg.wp.mymoviedatabase.service;

import de.dhbw.ravensburg.wp.mymoviedatabase.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    Movie getMovieById(long id);
    void removeMovieById(long id);
    Movie addMovie(Movie movie);
    Movie updateMovie(Movie movie);
}
