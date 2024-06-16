package org.ztw.charades.Round;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/rounds")
@RestController
public class RoundController {
    private final IRoundService roundService;

    public RoundController(IRoundService roundService) {
        this.roundService = roundService;
    }

    @GetMapping
    public ResponseEntity<Collection<Round>> getRounds() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(roundService.getRounds());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Round> getRound(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(roundService.getRound(id));
    }

    @PostMapping
    public ResponseEntity<Round> addRound(@RequestBody Round round) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(roundService.addRound(round));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Round> updateRound(@PathVariable("id") Long id, @RequestBody Round round) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(roundService.updateRound(id, round));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteRound(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(roundService.deleteRound(id));
    }
}
