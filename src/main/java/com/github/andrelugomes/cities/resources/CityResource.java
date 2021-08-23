package com.github.andrelugomes.cities.resources;

import com.github.andrelugomes.cities.entities.City;
import com.github.andrelugomes.cities.repositories.CityRepository;
import com.github.andrelugomes.countries.entities.Country;
import com.github.andrelugomes.staties.entities.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Optional;

@RestController
@RequestMapping("cities")
public class CityResource {

  private final CityRepository repository;

  public CityResource(final CityRepository repository) {
    this.repository = repository;
  }

  /* 1st
  @GetMapping
  public List<City> cities() {
      return repository.findAll();
  }*/

  // 2nd - Pageable
  @GetMapping
  public Page<City> cities(final Pageable page) {return repository.findAll(page);
  }

  @GetMapping("/{id}")
  public ResponseEntity getOne(@PathVariable Long id) {
    Optional<City> optional = repository.findById(id);
    if (optional.isPresent()) {
      return ResponseEntity.ok().body(optional.get());
    } else {
      ResponseEntity msgBadRequest = new ResponseEntity("City not found", HttpStatus.NOT_FOUND);
      return msgBadRequest;
    }
  }
}
