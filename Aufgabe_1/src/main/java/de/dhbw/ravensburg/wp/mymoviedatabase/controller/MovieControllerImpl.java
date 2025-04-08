package de.dhbw.ravensburg.wp.mymoviedatabase.controller;

import de.dhbw.ravensburg.wp.mymoviedatabase.service.MovieService;
import de.dhbw.ravensburg.wp.mymoviedatabase.service.ArtistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MovieControllerImpl implements MovieController {
    private final MovieService movieService;
    private final ArtistService artistService;

    @Autowired
    public MovieControllerImpl(MovieService movieService, ArtistService artistService) {
        this.movieService = movieService;
        this.artistService = artistService;
    }

    public String getName(){
        return "MovieControllerImpl";
    }

    public String getMovieServiceName() {
        return movieService.getName();
    }

    public String getMovieArtistName() {
        return artistService.getName();
    }
}
