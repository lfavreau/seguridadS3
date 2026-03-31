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

    @PostMapping
    public Animal save(@RequestBody Animal animal) {
        return service.save(animal);
    }
}