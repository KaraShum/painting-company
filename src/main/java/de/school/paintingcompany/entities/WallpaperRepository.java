package de.school.paintingcompany.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WallpaperRepository extends JpaRepository<Wallpaper, Long> {
}
