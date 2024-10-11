package com.f24_crud_api_assignment4.Animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal getAnimalById(int id) {
        return animalRepository.findById(id).orElse(null);
    }

    public List<Animal> getAnimalsBySpecies(String species) {
        return animalRepository.getAnimalsBySpecies(species);
    }

    public List<Animal> getAnimalsName(String name){
        return animalRepository.getAnimalsByName(name);
    }

    public Animal addAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public void updateAnimal(int animalId, Animal animal) {
        Animal existingAnimal = getAnimalById(animalId);
        if (existingAnimal != null) {
            existingAnimal.setName(animal.getName());
            existingAnimal.setScientificName(animal.getScientificName());
            existingAnimal.setSpecies(animal.getSpecies());
            existingAnimal.setHabitat(animal.getHabitat());
            existingAnimal.setDescription(animal.getDescription());
            animalRepository.save(existingAnimal);
        }
    }

    public void deleteAnimal(int animalId) {
        animalRepository.deleteById(animalId);
    }
}
