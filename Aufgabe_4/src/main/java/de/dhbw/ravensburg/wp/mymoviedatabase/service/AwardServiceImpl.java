package de.dhbw.ravensburg.wp.mymoviedatabase.service;

import de.dhbw.ravensburg.wp.mymoviedatabase.model.Award;
import de.dhbw.ravensburg.wp.mymoviedatabase.repository.AwardRepository;
import de.dhbw.ravensburg.wp.mymoviedatabase.repository.MovieRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AwardServiceImpl implements AwardService {

    private AwardRepository awardRepository;

    public AwardServiceImpl (AwardRepository awardRepository){
        this.awardRepository = awardRepository;
    }

    @Override
    public Award addAward(Award new_award){
        return this.awardRepository.save(new_award);
    }
    @Override
    public Award getAwardById(long id){
        return this.awardRepository.findById(id).get();
    }
    @Override
    public List<Award> getAllAwards(){
        return this.awardRepository.findAll();
    }
    @Override
    public Award updateAward(Award updated_award){
        if(awardRepository.existsById(updated_award.getId())){
            return this.awardRepository.save(updated_award);
        }else{
            throw new EntityNotFoundException("MovieId does not exist");
        }
    }
    @Override
    public void removeAwardById(long id){
        this.awardRepository.deleteById(id);
    }


}
