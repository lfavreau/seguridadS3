package cl.duoc.animales.service;

import java.util.List;
import org.springframework.stereotype.Service;
import cl.duoc.animales.model.Animal;
import cl.duoc.animales.repository.AnimalRepository;

@Service
public class AnimalService {

    private final AnimalRepository repo;

    public AnimalService(AnimalRepository repo) {
        this.repo = repo;
    }

    public List<Animal> getAll() {
        return repo.findAll();
    }

    public Animal save(Animal animal) {
        return repo.save(animal);
    }
}