package de.dhbw.ravensburg.wp.mymoviedatabase.controller;

import de.dhbw.ravensburg.wp.mymoviedatabase.service.ArtistServiceImpl;
import de.dhbw.ravensburg.wp.mymoviedatabase.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MovieControllerImpl {
    private final MovieServiceImpl movieService;
    private final ArtistServiceImpl artistService;

    @Autowired
    public MovieControllerImpl(MovieServiceImpl movieService){
        this.movieService = movieService;
        this.artistService = new ArtistServiceImpl();
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
