package de.school.paintingcompany.config;

import de.school.paintingcompany.entities.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ColorRepository colorRepository, WallpaperRepository wallpaperRepository, UserRepository userRepository) {
        return args -> {
            log.info("Preloading " + colorRepository.save(new Color("#730c63","Purpur", 12, 2.5, 30)));
            log.info("Preloading " + colorRepository.save(new Color("#FFFFFF", "Weiß", 25, 12, 60)));
            log.info("Preloading " + wallpaperRepository.save(new Wallpaper("Raufaser Vlies", "Weiß", 18.75, 0.53, 0, 4)));
            log.info("Preloading " + wallpaperRepository.save(new Wallpaper("Blumenmuster", "Grün", 3, 4, 0.64, 9)));
            log.info("Preloading " + userRepository.save(new User("admin", "admin", "admin@admin.de", "admin", Role.ADMIN )));
            log.info("Preloading " + userRepository.save(new User( "user", "user", "user@user.de", "user", Role.USER )));
        };
    }
}
