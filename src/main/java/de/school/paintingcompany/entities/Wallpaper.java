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
    private String color;
    private double rollLength;
    private double rollWidth;
    private double rapport;
    private double price;

    public Wallpaper() {

    }

    public Wallpaper(String name, String color, double rollLength, double rollWidth, double rapport, double price) {
        this.name = name;
        this.color = color;
        this.rollLength = rollLength;
        this.rollWidth = rollWidth;
        this.rapport = rapport;
        this.price = price;
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

    public double isHasRapport() {
        return rapport;
    }

    public void setHasRapport(double rapport) {
        this.rapport = rapport;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallpaper wallpaper = (Wallpaper) o;
        return Double.compare(rollLength, wallpaper.rollLength) == 0 && Double.compare(rollWidth, wallpaper.rollWidth) == 0 && Double.compare(rapport, wallpaper.rapport) == 0 && Double.compare(price, wallpaper.price) == 0 && Objects.equals(id, wallpaper.id) && Objects.equals(name, wallpaper.name) && Objects.equals(color, wallpaper.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, color, rollLength, rollWidth, rapport, price);
    }

    @Override
    public String toString() {
        return "Wallpaper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", rollLength=" + rollLength +
                ", rollWidth=" + rollWidth +
                ", rapport=" + rapport +
                ", price=" + price +
                '}';
    }
}
