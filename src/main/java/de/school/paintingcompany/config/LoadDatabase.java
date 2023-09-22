package de.school.paintingcompany.config;

import de.school.paintingcompany.entities.Color;
import de.school.paintingcompany.entities.ColorRepository;
import de.school.paintingcompany.entities.Wallpaper;
import de.school.paintingcompany.entities.WallpaperRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ColorRepository colorRepository, WallpaperRepository wallpaperRepository) {
        return args -> {
            log.info("Preloading " + colorRepository.save(new Color("Blau", 4.50)));
            log.info("Preloading " + colorRepository.save(new Color("blue", 3.35)));
            log.info("Preloading " + colorRepository.save(new Color("green", 2.50)));
            log.info("Preloading " + wallpaperRepository.save(new Wallpaper("wallaper1", 5, 6, 2.30, true)));
            log.info("Preloading " + wallpaperRepository.save(new Wallpaper("wallpaper2", 3, 4, 1.50, false)));
            log.info("Preloading " + wallpaperRepository.save(new Wallpaper("wallpaper3", 2, 3, 1.00, true)));
        };
    }
}
