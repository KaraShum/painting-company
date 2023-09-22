package de.school.paintingcompany.controller;

import de.school.paintingcompany.entities.Wallpaper;
import de.school.paintingcompany.entities.WallpaperRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:5173")
@RequestMapping("/api/v1")
public class WallpaperController {

    WallpaperRepository wallpaperRepository;

    public WallpaperController(WallpaperRepository wallpaperRepository) {
        this.wallpaperRepository = wallpaperRepository;
    }

    @GetMapping("/wallpapers")
    public List<Wallpaper> getAll() {
        return wallpaperRepository.findAll();
    }

    @GetMapping("/wallpapers/{id}")
    public Wallpaper getById(Long id) {
        return wallpaperRepository.findById(id).orElseThrow();
    }

    @PostMapping("/wallpapers")
    public Wallpaper create(@RequestBody Wallpaper wallpaper) {
        return wallpaperRepository.save(wallpaper);
    }

    @DeleteMapping("/wallpapers/{id}")
    public void delete(@PathVariable Long id) {
        wallpaperRepository.deleteById(id);
    }
}
