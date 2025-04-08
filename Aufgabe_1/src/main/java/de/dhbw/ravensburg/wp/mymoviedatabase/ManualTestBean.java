package de.dhbw.ravensburg.wp.mymoviedatabase;

import de.dhbw.ravensburg.wp.mymoviedatabase.controller.MovieControllerImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ManualTestBean {
    // Vorsicht diese Klasse ist nur für Übungszwecke,
    // sie sollte nie in einer produktiven Applikation sein

    MovieControllerImpl movieController;

    @Autowired
    ManualTestBean(MovieControllerImpl movieController){
        this.movieController = movieController;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void callController(){
        // Test Movie Controller
        log.info(this.movieController.getName());
        // Test Movie Service
        log.info(this.movieController.getMovieServiceName());
        // Test Artist Service
        log.info(this.movieController.getMovieArtistName());
    }

}
