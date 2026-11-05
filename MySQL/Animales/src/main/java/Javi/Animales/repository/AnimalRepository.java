//Puente de comunicacion entre aplicacion y BD
package Javi.Animales.repository;

import Christian.Animales.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Al poner extends JpaRepostory estas heredando las funciones de find,save,delete
@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

}