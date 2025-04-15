package de.dhbw.ravensburg.wp.mymoviedatabase.service;

import de.dhbw.ravensburg.wp.mymoviedatabase.model.Movie;
import de.dhbw.ravensburg.wp.mymoviedatabase.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService{

    private MovieRepository movieRepository;


    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    //Im Transaktionskontext können LazyLoading Beziehungen aufgelöst werden
    @Transactional
    public List<String> getCastOfMovie(String movieTitle){
        List<String> result = new LinkedList<>();
        List<Movie> tmp = this.movieRepository.findByTitleContaining(movieTitle);
        if (tmp.size() == 1){
            tmp.get(0).getInvolvedCast().forEach(cast -> result.add(cast.getForename()));
        }
        return result;
    }

    @Transactional
    public void changeMovieTitle(long id, String newMovieName){
        if (!newMovieName.isEmpty()){
            Movie tmp = this.movieRepository.findById(id).get();
            tmp.setTitle(newMovieName);
        } else {
            log.warn("Error with changing movie title with title: " + newMovieName);
        }
    }

}
