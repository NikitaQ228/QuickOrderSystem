package ru.nikita.QuickOrderSystem.entity;

import dto.DishDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    private String description;

    @Column(nullable = false)
    private double price;

    public Dish(String name, String category, String description, double price) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
    }

    public Dish(DishDto dto) {
        this.name = dto.getName();
        this.category = dto.getCategory();
        this.description = dto.getDescription();
        this.price = dto.getPrice();
    }
}
