package cl.duoc.animales.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import cl.duoc.animales.model.Animal;
import cl.duoc.animales.model.Usuario;
import cl.duoc.animales.repository.AnimalRepository;
import cl.duoc.animales.repository.UsuarioRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(
            UsuarioRepository usuarioRepo,
            AnimalRepository animalRepo,
            PasswordEncoder encoder) {
        return args -> {

            if (usuarioRepo.count() == 0) {
                usuarioRepo.save(Usuario.builder()
                        .username("admin")
                        .password(encoder.encode("1234"))
                        .role("ADMIN")
                        .build());

                usuarioRepo.save(Usuario.builder()
                        .username("user")
                        .password(encoder.encode("1234"))
                        .role("USER")
                        .build());

                usuarioRepo.save(Usuario.builder()
                        .username("test")
                        .password(encoder.encode("1234"))
                        .role("USER")
                        .build());
            }

            if (animalRepo.count() == 0) {
                animalRepo.save(Animal.builder()
                        .nombre("Luna")
                        .especie("Perro")
                        .raza("Mestiza")
                        .edad(3)
                        .ubicacion("Concepción")
                        .estadoAdopcion("Disponible")
                        .build());

                animalRepo.save(Animal.builder()
                        .nombre("Milo")
                        .especie("Gato")
                        .raza("Común europeo")
                        .edad(2)
                        .ubicacion("Talcahuano")
                        .estadoAdopcion("Disponible")
                        .build());
            }
        };
    }
}