package de.school.paintingcompany.controller;

import de.school.paintingcompany.entities.Color;
import de.school.paintingcompany.entities.ColorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1")
public class ColorController {

    ColorRepository colorRepository;

    public ColorController(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    @GetMapping("/colors")
    public List<Color> getAll() {
        return colorRepository.findAll();
    }

    @GetMapping("/colors/{id}")
    public Color getById(Long id) {
        return colorRepository.findById(id).orElseThrow();
    }

    @PostMapping("/colors")
    public Color create(@RequestBody Color color) {
        return colorRepository.save(color);
    }

    @PutMapping("/colors/{id}")
    public Color update(@RequestBody Color color) {
        return colorRepository.save(color);
    }

    @DeleteMapping("/colors/{id}")
    public void delete(@PathVariable Long id) {
        colorRepository.deleteById(id);
    }
}
