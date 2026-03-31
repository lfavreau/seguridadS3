package cl.duoc.animales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.duoc.animales.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}