package cl.duoc.animales.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import cl.duoc.animales.model.Animal;
import cl.duoc.animales.service.AnimalService;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService service;

    public AnimalController(AnimalService service) {
        this.service = service;
    }

    @GetMapping
    public List<Animal> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Animal getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/search")
    public List<Animal> buscar(
            @RequestParam(required = false) String especie,
            @RequestParam(required = false) String ubicacion,
            @RequestParam(required = false) Integer edad,
            @RequestParam(required = false) String genero) {
        return service.buscar(especie, ubicacion, edad, genero);
    }

    @PostMapping
    public Animal save(@RequestBody Animal animal) {
        return service.save(animal);
    }

    @PutMapping("/{id}")
    public Animal update(@PathVariable Long id, @RequestBody Animal animal) {
        return service.update(id, animal);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}