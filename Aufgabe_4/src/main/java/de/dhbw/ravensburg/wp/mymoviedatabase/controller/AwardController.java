package de.dhbw.ravensburg.wp.mymoviedatabase.controller;

import de.dhbw.ravensburg.wp.mymoviedatabase.model.Award;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface AwardController {
    @GetMapping
    List<Award> getAllAwards();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Award addAward(@RequestBody Award award);

    @GetMapping("/{awardId}")
    Award getAwardById(@PathVariable("awardId") Long awardId);

    @PutMapping("/{awardId}")
    Award updateAward(@PathVariable("awardId") Long awardId, @RequestBody Award award);

    @DeleteMapping("/{awardId}")
    void deleteAwardById(@PathVariable("awardId") Long awardId);

}
