package Animales.animal.services;

import Animales.animal.models.animal;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import Animales.animal.Repository.AnimalRepository;
import java.util.Optional;

@Service
public class AnimalService {
    private final AnimalRepository repo;

    public AnimalService(AnimalRepository repo) {
        this.repo = repo;
    }
    public List<animal> findAll() {
        return repo.findAll();
    }

    public animal findById(int id) {
        Optional<animal> animal = repo.findById(id);
        return animal.orElse(null);
    }
    public void guardar(animal animal){
        repo.save(animal);
    }
    public void actualizar(int id, animal animalActu){
        repo.save(animalActu);
    }
    public void eliminar(int id){
        repo.deleteById(id);
    }
}

