package com.github.andrelugomes.countries.resources;
import com.github.andrelugomes.cities.service.DistanceService;
import com.github.andrelugomes.countries.entities.Country;
import com.github.andrelugomes.countries.repositories.CountryRepository;
import org.apache.logging.log4j.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class  CountryResource {
  Logger log = LoggerFactory.getLogger(Country.class);
  private final CountryRepository repository;

  public CountryResource(final CountryRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public Page<Country> countries(Pageable page) {

    return repository.findAll(page);
  }
  @GetMapping("/{id}")
  public ResponseEntity getOne(@PathVariable Long id) {
        System.out.println(id.getClass().getSimpleName());

//    if (id.getClass().getSimpleName()!="Long"){
//      ResponseEntity msgBadRequest = new ResponseEntity("Id requires numbers only", HttpStatus.BAD_REQUEST);
//      return  msgBadRequest;
//    }

    Optional<Country> optional= repository.findById(id);
    if(optional.isPresent()){
      return ResponseEntity.ok().body(optional.get());
    }else{
      ResponseEntity msgNotFound = new ResponseEntity("Country not found", HttpStatus.NOT_FOUND);
      return  msgNotFound;
    }

  }
}
