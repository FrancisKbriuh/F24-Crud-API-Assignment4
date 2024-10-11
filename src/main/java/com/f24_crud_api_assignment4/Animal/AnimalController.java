package com.f24_crud_api_assignment4.Animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    @GetMapping("/all")
    public List<Animal> getAllAnimals() {
        return service.getAllAnimals();
    }

    @GetMapping("/{animalId}")
    public Animal getAnimalById(@PathVariable int animalId) {
        return service.getAnimalById(animalId);
    }

    @PostMapping("/new")
    public ResponseEntity<Animal> addNewAnimal(@RequestBody Animal animal) {
        Animal createdAnimal = service.addAnimal(animal);
        return new ResponseEntity<>(createdAnimal, HttpStatus.CREATED);
    }


    @PutMapping("/update/{animalId}")
    public Animal updateAnimal(@PathVariable int animalId, @RequestBody Animal animal) {
        service.updateAnimal(animalId, animal);
        return service.getAnimalById(animalId);
    }

    @DeleteMapping("/delete/{animalId}")
    public List<Animal> deleteAnimal(@PathVariable int animalId) {
        service.deleteAnimal(animalId);
        return service.getAllAnimals();
    }

    @GetMapping("/species")
    public List<Animal> getAnimalsBySpecies(@RequestParam String species) {
        return service.getAnimalsBySpecies(species);
    }

    @GetMapping("/search")
    public List<Animal> getAnimalsByName(@RequestParam String name) {
        return service.getAnimalsName(name);
    }
}
