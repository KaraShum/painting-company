package de.school.paintingcompany.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Objects;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Color {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String color;
    private String name;
    private double price;
    private double containerSize;
    private double areaPerContainer;

    public Color(String color, String name, double price, double containerSize, double areaPerContainer) {
        this.color = color;
        this.name = name;
        this.price = price;
        this.containerSize = containerSize;
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
