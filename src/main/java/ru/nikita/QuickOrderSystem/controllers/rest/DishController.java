package ru.nikita.QuickOrderSystem.controllers.rest;

import dto.DishDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nikita.QuickOrderSystem.entity.Dish;
import ru.nikita.QuickOrderSystem.services.DishService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dish")
public class DishController {

    private final DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/menu")
    public ResponseEntity<Map<String, List<Dish>>> getMenu() {
        return ResponseEntity.status(HttpStatus.OK).body(dishService.getMenu());
    }

    @PostMapping
    public ResponseEntity<Dish> addDish(@RequestBody DishDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dishService.addDish(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDish(@PathVariable Long id) {
        dishService.deleteDish(id);
        return ResponseEntity.noContent().build();
    }
}
