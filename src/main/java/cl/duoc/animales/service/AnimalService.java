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

    public Animal getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Animal no encontrado"));
    }

    public Animal save(Animal animal) {
        return repo.save(animal);
    }

    public Animal update(Long id, Animal animalActualizado) {
        Animal animal = getById(id);

        animal.setNombre(animalActualizado.getNombre());
        animal.setEspecie(animalActualizado.getEspecie());
        animal.setRaza(animalActualizado.getRaza());
        animal.setEdad(animalActualizado.getEdad());
        animal.setGenero(animalActualizado.getGenero());
        animal.setUbicacion(animalActualizado.getUbicacion());
        animal.setEstadoAdopcion(animalActualizado.getEstadoAdopcion());
        animal.setFoto(animalActualizado.getFoto());

        return repo.save(animal);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Animal> buscar(String especie, String ubicacion, Integer edad, String genero) {
        if (especie != null && !especie.isBlank()) {
            return repo.findByEspecieContainingIgnoreCase(especie);
        }
        if (ubicacion != null && !ubicacion.isBlank()) {
            return repo.findByUbicacionContainingIgnoreCase(ubicacion);
        }
        if (edad != null) {
            return repo.findByEdad(edad);
        }
        if (genero != null && !genero.isBlank()) {
            return repo.findByGeneroContainingIgnoreCase(genero);
        }
        return repo.findAll();
    }
}