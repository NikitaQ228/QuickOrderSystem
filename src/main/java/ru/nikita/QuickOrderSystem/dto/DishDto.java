package ru.nikita.QuickOrderSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishDto {
    private String name;
    private String category;
    private String description;
    private double price;
}
