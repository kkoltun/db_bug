package com.minimal.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  private static final Logger log = LoggerFactory.getLogger(Controller.class);

  @Autowired PersonRepository repository;

  @GetMapping(value = "/")
  public void test() {
    try {
      repository.findByFirstName("Fix").ifPresent(this::personFound);
    } catch (Exception e) {
      log.error("Exception caught: {}", e.getMessage());
    }
  }

  private void personFound(Person person) {
    log.info("Person found: {} {}!", person.getFirstName(), person.getLastName());
  }
}
