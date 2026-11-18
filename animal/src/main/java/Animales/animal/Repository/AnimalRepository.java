package Animales.animal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Animales.animal.models.animal;

@Repository
public interface AnimalRepository extends JpaRepository<animal, Integer> {
}