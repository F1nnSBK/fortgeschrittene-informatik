package de.dhbw.ravensburg.wp.mymoviedatabase.controller;

import de.dhbw.ravensburg.wp.mymoviedatabase.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MovieControllerImpl {
    private final MovieServiceImpl movieService;

    @Autowired
    public MovieControllerImpl(MovieServiceImpl movieService){
        this.movieService = movieService;
    }

    public String getName(){
        return "MovieControllerImpl";
    }

    public String getMovieServiceName() {
        return movieService.getName();
    }
}
