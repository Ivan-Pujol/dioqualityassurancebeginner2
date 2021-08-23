package com.github.andrelugomes.staties.resources;

import com.github.andrelugomes.countries.entities.Country;
import com.github.andrelugomes.staties.entities.State;
import com.github.andrelugomes.staties.repositories.StateRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staties")
public class  StateResource {

  private final StateRepository repository;

  public StateResource(final StateRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<State> staties() {
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity getOne(@PathVariable Long id) {
    Optional<State> optional = repository.findById(id);
    if (optional.isPresent()) {
      return ResponseEntity.ok().body(optional.get());
    } else {
      ResponseEntity msgBadRequest = new ResponseEntity("State not found", HttpStatus.NOT_FOUND);
      return msgBadRequest;
    }
  }
}
