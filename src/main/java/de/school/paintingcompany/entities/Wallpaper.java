package de.school.paintingcompany.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Objects;

import static jakarta.persistence.GenerationType.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Wallpaper {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String color;
    private double rollLength;
    private double rollWidth;
    private double rapport;
    private double price;

    public Wallpaper(String name, String color, double rollLength, double rollWidth, double rapport, double price) {
        this.name = name;
        this.color = color;
        this.rollLength = rollLength;
        this.rollWidth = rollWidth;
        this.rapport = rapport;
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
