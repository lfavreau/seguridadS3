package cl.duoc.animales.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import cl.duoc.animales.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByEspecieContainingIgnoreCase(String especie);
    List<Animal> findByUbicacionContainingIgnoreCase(String ubicacion);
    List<Animal> findByGeneroContainingIgnoreCase(String genero);
    List<Animal> findByEdad(int edad);
}