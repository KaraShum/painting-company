package de.school.paintingcompany.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Wallpaper {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double rollLength;
    private double rollWidth;
    private double rapport;
    private boolean hasRapport;

    public Wallpaper() {

    }

    public Wallpaper(String name, double rollLength, double rollWidth, double rapport, boolean hasRapport) {
        this.name = name;
        this.rollLength = rollLength;
        this.rollWidth = rollWidth;
        this.rapport = rapport;
        this.hasRapport = hasRapport;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRollLength() {
        return rollLength;
    }

    public void setRollLength(double rollLength) {
        this.rollLength = rollLength;
    }

    public double getRollWidth() {
        return rollWidth;
    }

    public void setRollWidth(double rollWidth) {
        this.rollWidth = rollWidth;
    }

    public double getRapport() {
        return rapport;
    }

    public void setRapport(double rapport) {
        this.rapport = rapport;
    }

    public boolean isHasRapport() {
        return hasRapport;
    }

    public void setHasRapport(boolean hasRapport) {
        this.hasRapport = hasRapport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallpaper wallpaper = (Wallpaper) o;
        return Double.compare(wallpaper.rollLength, rollLength) == 0 && Double.compare(wallpaper.rollWidth, rollWidth) == 0 && Double.compare(wallpaper.rapport, rapport) == 0 && hasRapport == wallpaper.hasRapport && Objects.equals(name, wallpaper.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rollLength, rollWidth, rapport, hasRapport);
    }

    @Override
    public String toString() {
        return "Wallpaper{" +
                "name='" + name + '\'' +
                ", rollLength=" + rollLength +
                ", rollWidth=" + rollWidth +
                ", rapport=" + rapport +
                ", hasRapport=" + hasRapport +
                '}';
    }
}
