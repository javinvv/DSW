package Animales.animal;

import Animales.animal.models.animal;
import Animales.animal.Repository.AnimalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AnimalApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalApplication.class, args);
	}
	@Bean
	CommandLineRunner seedAnimals(AnimalRepository ar) {
		return args -> {
			if (ar.count() == 0) {
				ar.save(new animal("Gato", 20, false));
				ar.save(new animal("Perro", 20, false));
				ar.save(new animal("Mamut", 300, true));
			}
		};
	}
}
