package de.dhbw.ravensburg.wp.mymoviedatabase.service;

import de.dhbw.ravensburg.wp.mymoviedatabase.model.Movie;
import de.dhbw.ravensburg.wp.mymoviedatabase.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAllMovies(){
        return this.movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(long id){
        return this.movieRepository.findById(id).get();
    }

    @Override
    public void removeMovieById(long id){
        this.movieRepository.deleteById(id);
    }

    @Override
    public Movie addMovie(Movie new_movie){
        return this.movieRepository.save(new_movie);
    }

    @Override
    public Movie updateMovie(Movie updated_movie){
        if(movieRepository.existsById(updated_movie.getId())){
            return this.movieRepository.save(updated_movie);
        }else{
            throw new EntityNotFoundException("MovieId does not exist");
        }
    }

}
