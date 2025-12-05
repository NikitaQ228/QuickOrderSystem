package ru.nikita.QuickOrderSystem.services.impl;

import dto.DishDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nikita.QuickOrderSystem.entity.Dish;
import ru.nikita.QuickOrderSystem.repository.DishRepository;
import ru.nikita.QuickOrderSystem.services.DishService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

@Service
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public Map<String, List<Dish>> getMenu() {
        List<Dish> dishes = dishRepository.findAllByOrderByCategoryAscNameAsc();
        return dishes.stream()
                .collect(Collectors.groupingBy(
                        Dish::getCategory,
                        LinkedHashMap::new,
                        Collectors.toList()
                ));
    }

    @Override
    public void deleteDish(Long id) {
        if (!dishRepository.existsById(id)) {
            throw new EntityNotFoundException("Dish with id " + id + " not found");
        }
        dishRepository.deleteById(id);
    }

    @Override
    public Dish addDish(DishDto dishDto) {
        return dishRepository.save(new Dish(dishDto));
    }
}
