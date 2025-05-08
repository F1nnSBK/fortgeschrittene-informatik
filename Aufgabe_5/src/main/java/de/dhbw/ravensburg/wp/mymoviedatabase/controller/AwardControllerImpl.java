package de.dhbw.ravensburg.wp.mymoviedatabase.controller;

import de.dhbw.ravensburg.wp.mymoviedatabase.dto.AwardDTO;
import de.dhbw.ravensburg.wp.mymoviedatabase.service.AwardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/awards")
public class AwardControllerImpl implements AwardController {

    private AwardService awardService;

    public AwardControllerImpl(AwardService awardService){
        this.awardService = awardService;
    }

    @Override
    @GetMapping
    public List<AwardDTO> getAllAwards(){
        return this.awardService.getAllAwards();
    }

    @Override
    @GetMapping("/{awardId}")
    public AwardDTO getAwardById(@PathVariable("awardId") Long awardId){
        try {
            return this.awardService.getAwardById(awardId);
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @DeleteMapping("/{awardId}")
    public void removeAwardById(@PathVariable("awardId") Long awardId){
        try {
            this.awardService.removeAwardById(awardId);
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AwardDTO addAward(@Valid @RequestBody AwardDTO awardDTO){
        return this.awardService.addAward(awardDTO);

    }

    @Override
    @PutMapping("/{awardId}")
    public AwardDTO updateAward(@PathVariable("awardId") Long awardId, @Valid @RequestBody AwardDTO awardDTO){
        awardDTO.setId(awardId);
        try {
            return this.awardService.updateAward(awardDTO);
        } catch (EntityNotFoundException notFoundException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }



}
