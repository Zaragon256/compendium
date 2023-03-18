package com.zaragon256.compendium;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CreatureController {

    private final CreatureRepository repository;

    public CreatureController(CreatureRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/creatures")
    List<Creature> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/creatures")
    Creature newCreature(@RequestBody Creature newCreature){
        return repository.save(newCreature);
    }

    // Single item
    @GetMapping("/creatures/{id}")
    Creature one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new CreatureNotFoundException(id));
    }

    @PutMapping("/creatures/{id}")
    Creature replaceCreature(@RequestBody Creature newCreature, @PathVariable Long id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newCreature.getName());
                    employee.setType(newCreature.getType());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newCreature.setId(id);
                    return repository.save(newCreature);
                });
    }


    @DeleteMapping("/creatures/{id}")
    void deleteCreature(@PathVariable Long id) {
        repository.deleteById(id);
    }


}
