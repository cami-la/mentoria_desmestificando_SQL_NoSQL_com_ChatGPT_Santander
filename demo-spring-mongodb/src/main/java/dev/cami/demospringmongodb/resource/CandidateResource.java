package dev.cami.demospringmongodb.resource;

import dev.cami.demospringmongodb.document.Candidate;
import dev.cami.demospringmongodb.service.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidates")
public record CandidateResource(
    CandidateService candidateService
) {

  @PostMapping
  public ResponseEntity<Candidate> create(@RequestBody Candidate candidate) {
    Candidate savedCandidate = candidateService.create(candidate);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedCandidate);
  }
}
