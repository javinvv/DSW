package Javi.Animales;

import Christian.Animales.models.Animal;
import Christian.Animales.repository.AnimalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AnimalesApplication {
	public static void main(String[] args) {
		SpringApplication.run(AnimalesApplication.class, args);
	}
	@Bean
	CommandLineRunner seedAnimals(AnimalRepository animalRepository) {
		return args -> {
			// Solo inserta si la tabla está vacía
			if (animalRepository.count() == 0) {
				animalRepository.save(new Animal(null, "León", 15, false));
				animalRepository.save(new Animal(null, "Tortuga Gigante", 150, false));
				animalRepository.save(new Animal(null, "Dodo", 20, true));

				System.out.println("¡Datos iniciales de animales insertados correctamente!");
			}
		};
	}
}
