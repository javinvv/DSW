package Animales.animal.services;

import Animales.animal.models.animal;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class AnimalService {
    private final List<animal> animals = new ArrayList<>();
    public AnimalService() {
        animals.add(new animal(1, "Gato", 20, false));
        animals.add(new animal(2, "Perro", 20, false));
        animals.add(new animal(3, "Mamut", 300, true));
    }
    public List<animal> findAll() { return animals; }

    public animal findById(int id){
        for(animal Animal : animals){
            if(Animal.getId() == id){
                return Animal;
            }
        }
        return null;
    }
    public void actualizar(int id, animal AnimalActu){
        for(int i = 0; i < animals.size(); i++){
            if(animals.get(i).getId() == id){
                AnimalActu.setId(id);
                animals.set(i, AnimalActu);
                break;
            }
        }
    }
    public void guardar(animal animal){
        animal.setId(this.animals.size() + 1);
        this.animals.add(animal);
    }
    public void eliminar(int id){
        animals.removeIf(animal -> animal.getId() == id);
    }
}
