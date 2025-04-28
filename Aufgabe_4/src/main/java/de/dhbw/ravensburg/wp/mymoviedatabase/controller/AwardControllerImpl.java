package de.dhbw.ravensburg.wp.mymoviedatabase.controller;

import de.dhbw.ravensburg.wp.mymoviedatabase.model.Award;
import de.dhbw.ravensburg.wp.mymoviedatabase.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/awards")
public class AwardControllerImpl {

    AwardService awardService;

    @Autowired
    public AwardControllerImpl(AwardService awardService) {
        this.awardService = awardService;
    }

    @GetMapping
    public List<Award> getAllAwards() { return this.awardService.getAllAwards(); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Award addAward(@RequestBody Award award) {
        return this.awardService.addAward(award);
    }

    @GetMapping("/{awardId}")
    public Award getAwardById(@PathVariable("awardId") Long awardId) {
        return this.awardService.getAwardById(awardId);
    }

    @PutMapping("/{awardId}")
    public Award updateAward(@PathVariable("awardId") Long awardId, @RequestBody Award award) {
        award.setId(awardId);
        return this.awardService.updateAward(award);
    }

    @DeleteMapping("/{awardId}")
    public void deleteAwardById(@PathVariable("awardId") Long awardId) {
        this.awardService.removeAwardById(awardId);
    }


}
