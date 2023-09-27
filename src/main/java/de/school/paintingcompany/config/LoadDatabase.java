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
            log.info("Preloading " + colorRepository.save(new Color("#730c63","Purpur", 12, 2.5, 30)));
            log.info("Preloading " + colorRepository.save(new Color("#FFFFFF", "Weiß", 25, 12, 60)));
            log.info("Preloading " + wallpaperRepository.save(new Wallpaper("Raufaser Vlies", "Weiß", 18.75, 0.53, 0, 4)));
            log.info("Preloading " + wallpaperRepository.save(new Wallpaper("Blumenmuster", "Grün", 3, 4, 0.64, 9)));
        };
    }
}
