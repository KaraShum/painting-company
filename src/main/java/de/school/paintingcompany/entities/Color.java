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
    private String name;
    private double price;
    private double containerSize;
    private double areaPerContainer;

    public Color() {
    }

    public Color(String color, String name, double price, double containerSize, double areaPerContainer) {
        this.color = color;
        this.name = name;
        this.price = price;
        this.containerSize = containerSize;
        this.areaPerContainer = areaPerContainer;
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getContainerSize() {
        return containerSize;
    }

    public void setContainerSize(double containerSize) {
        this.containerSize = containerSize;
    }

    public double getAreaPerContainer() {
        return areaPerContainer;
    }

    public void setAreaPerContainer(double areaPerContainer) {
        this.areaPerContainer = areaPerContainer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color1 = (Color) o;
        return Double.compare(price, color1.price) == 0 && Double.compare(containerSize, color1.containerSize) == 0 && Double.compare(areaPerContainer, color1.areaPerContainer) == 0 && Objects.equals(id, color1.id) && Objects.equals(color, color1.color) && Objects.equals(name, color1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color, name, price, containerSize, areaPerContainer);
    }

    @Override
    public String toString() {
        return "Color{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", containerSize=" + containerSize +
                ", areaPerContainer=" + areaPerContainer +
                '}';
    }
}
