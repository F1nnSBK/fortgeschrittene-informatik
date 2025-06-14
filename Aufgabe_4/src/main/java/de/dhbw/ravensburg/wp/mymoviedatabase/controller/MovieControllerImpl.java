package de.dhbw.ravensburg.wp.mymoviedatabase.controller;

import de.dhbw.ravensburg.wp.mymoviedatabase.model.Movie;
import de.dhbw.ravensburg.wp.mymoviedatabase.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieControllerImpl implements MovieController {

    private MovieService movieService;

    public MovieControllerImpl(MovieService movieService){
        this.movieService = movieService;
    }


    @Override
    @GetMapping
    public List<Movie> getAllMovies(){
        return this.movieService.getAllMovies();
    }

    @Override
    @GetMapping("/{movieId}")
    public Movie getMovieById(@PathVariable("movieId") Long movieId){
        return this.movieService.getMovieById(movieId);
    }

    @Override
    @DeleteMapping("/{movieId}")
    public void deleteMovie(@PathVariable("movieId") Long movieId){
        this.movieService.removeMovieById(movieId);
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movie addMovie(@RequestBody Movie movie){
        return this.movieService.addMovie(movie);
    }

    @Override
    @PutMapping("/{movieId}")
    public Movie updateMovie(@PathVariable("movieId") Long movieId, @RequestBody Movie movie){
        movie.setId(movieId);
        return this.movieService.updateMovie(movie);
    }


}
