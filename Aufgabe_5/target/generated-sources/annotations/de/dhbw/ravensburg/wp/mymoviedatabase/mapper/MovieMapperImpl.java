package de.dhbw.ravensburg.wp.mymoviedatabase.mapper;

import de.dhbw.ravensburg.wp.mymoviedatabase.dto.AwardDTO;
import de.dhbw.ravensburg.wp.mymoviedatabase.dto.MovieDTO;
import de.dhbw.ravensburg.wp.mymoviedatabase.model.Award;
import de.dhbw.ravensburg.wp.mymoviedatabase.model.Cast;
import de.dhbw.ravensburg.wp.mymoviedatabase.model.Movie;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-28T11:32:50+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 16.0.2 (Azul Systems, Inc.)"
)
@Component
public class MovieMapperImpl implements MovieMapper {

    @Override
    public MovieDTO movieToMovieDTO(Movie movie) {
        if ( movie == null ) {
            return null;
        }

        MovieDTO movieDTO = new MovieDTO();

        movieDTO.setCastIds( castListToLongList( movie.getInvolvedCast() ) );
        movieDTO.setId( movie.getId() );
        movieDTO.setTitle( movie.getTitle() );
        movieDTO.setDuration( movie.getDuration() );
        movieDTO.setDescription( movie.getDescription() );
        movieDTO.setTrailerUrl( movie.getTrailerUrl() );
        movieDTO.setCoverImgUrl( movie.getCoverImgUrl() );
        movieDTO.setImdbRating( movie.getImdbRating() );
        movieDTO.setAwards( awardListToAwardDTOList( movie.getAwards() ) );

        return movieDTO;
    }

    @Override
    public List<MovieDTO> moviesToMovieDTOs(List<Movie> movies) {
        if ( movies == null ) {
            return null;
        }

        List<MovieDTO> list = new ArrayList<MovieDTO>( movies.size() );
        for ( Movie movie : movies ) {
            list.add( movieToMovieDTO( movie ) );
        }

        return list;
    }

    @Override
    public Movie movieDTOToMovie(MovieDTO movieDTO) {
        if ( movieDTO == null ) {
            return null;
        }

        Movie movie = new Movie();

        if ( movieDTO.getId() != null ) {
            movie.setId( movieDTO.getId() );
        }
        movie.setTitle( movieDTO.getTitle() );
        movie.setDuration( movieDTO.getDuration() );
        movie.setDescription( movieDTO.getDescription() );
        movie.setTrailerUrl( movieDTO.getTrailerUrl() );
        movie.setCoverImgUrl( movieDTO.getCoverImgUrl() );
        movie.setImdbRating( movieDTO.getImdbRating() );
        movie.setAwards( awardDTOListToAwardList( movieDTO.getAwards() ) );

        return movie;
    }

    @Override
    public List<Movie> movieDTOsToMovies(List<MovieDTO> movieDTOs) {
        if ( movieDTOs == null ) {
            return null;
        }

        List<Movie> list = new ArrayList<Movie>( movieDTOs.size() );
        for ( MovieDTO movieDTO : movieDTOs ) {
            list.add( movieDTOToMovie( movieDTO ) );
        }

        return list;
    }

    protected List<Long> castListToLongList(List<Cast> list) {
        if ( list == null ) {
            return null;
        }

        List<Long> list1 = new ArrayList<Long>( list.size() );
        for ( Cast cast : list ) {
            list1.add( map( cast ) );
        }

        return list1;
    }

    protected AwardDTO awardToAwardDTO(Award award) {
        if ( award == null ) {
            return null;
        }

        AwardDTO awardDTO = new AwardDTO();

        awardDTO.setId( award.getId() );
        awardDTO.setAcademy( award.getAcademy() );
        awardDTO.setCategory( award.getCategory() );

        return awardDTO;
    }

    protected List<AwardDTO> awardListToAwardDTOList(List<Award> list) {
        if ( list == null ) {
            return null;
        }

        List<AwardDTO> list1 = new ArrayList<AwardDTO>( list.size() );
        for ( Award award : list ) {
            list1.add( awardToAwardDTO( award ) );
        }

        return list1;
    }

    protected Award awardDTOToAward(AwardDTO awardDTO) {
        if ( awardDTO == null ) {
            return null;
        }

        Award award = new Award();

        if ( awardDTO.getId() != null ) {
            award.setId( awardDTO.getId() );
        }
        award.setAcademy( awardDTO.getAcademy() );
        award.setCategory( awardDTO.getCategory() );

        return award;
    }

    protected List<Award> awardDTOListToAwardList(List<AwardDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Award> list1 = new ArrayList<Award>( list.size() );
        for ( AwardDTO awardDTO : list ) {
            list1.add( awardDTOToAward( awardDTO ) );
        }

        return list1;
    }
}
