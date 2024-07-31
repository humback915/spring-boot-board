package org.springboot.board.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

//    private PersonRepositoryImpl personRepositoryImpl;
//
//    @PostMapping
//    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
//        Person savedPerson = personRepositoryImpl.savePerson(person);
//        return ResponseEntity.ok(savedPerson);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
//        Optional<Person> person = personRepositoryImpl.getPersonById(id);
//        return person.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Person>> getAllPersons() {
//        List<Person> persons = personRepositoryImpl.getAllPersons();
//        return ResponseEntity.ok(persons);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
//        personRepositoryImpl.deletePerson(id);
//        return ResponseEntity.noContent().build();
//    }

//    @GetMapping("/city/{city}")
//    public ResponseEntity<List<Person>> findPersonsLivingInCity(@PathVariable String city) {
//        List<Person> persons = personRepositoryImpl.findPersonsLivingInCity(city);
//        return ResponseEntity.ok(persons);
//    }
}
