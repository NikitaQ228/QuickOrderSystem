package ru.nikita.QuickOrderSystem.services;

import dto.DishDto;
import ru.nikita.QuickOrderSystem.entity.Dish;

import java.util.List;
import java.util.Map;

public interface DishService {
    Map<String, List<Dish>> getMenu();
    void deleteDish(Long id);
    Dish addDish(DishDto dishDto);
}
