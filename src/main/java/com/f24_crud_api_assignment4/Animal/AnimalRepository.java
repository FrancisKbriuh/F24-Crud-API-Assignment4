package com.f24_crud_api_assignment4.Animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List<Animal> getAnimalsBySpecies(String species);

    List<Animal> getAnimalsByName(String name);
}
