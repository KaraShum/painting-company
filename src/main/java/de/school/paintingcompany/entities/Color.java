package de.school.paintingcompany.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Color {

    @Id
    @GeneratedValue
    private Long id;

    private String color;
    private double price;

    public Color() {
    }

    public Color(String color, double price) {
        this.color = color;
        this.price = price;
    }

    public Long getId() {
        return id;
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
        Color color1 = (Color) o;
        return Double.compare(price, color1.price) == 0 && Objects.equals(id, color1.id) && Objects.equals(color, color1.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color, price);
    }

    @Override
    public String toString() {
        return "Color{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
