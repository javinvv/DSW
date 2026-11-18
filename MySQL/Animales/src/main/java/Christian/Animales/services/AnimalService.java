package Christian.Animales.services;

import Christian.Animales.models.Animal;
import Christian.Animales.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private final AnimalRepository repo;

    public AnimalService(AnimalRepository repo) {
        this.repo = repo;
    }

    public List<Animal> findAll() {
        return repo.findAll();
    }

    public Animal findById(Integer id) {
        Optional<Animal> animal = repo.findById(id);
        return animal.orElse(null);
    }

    public void guardar(Animal animal) {
        repo.save(animal);
    }

    public void eliminar(Integer id) {
        repo.deleteById(id);
    }

    public void actualizar(Animal animalActualizado) {
        repo.save(animalActualizado);
    }
}