package ru.nikita.QuickOrderSystem.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.nikita.QuickOrderSystem.entity.Dish;
import ru.nikita.QuickOrderSystem.entity.User;
import ru.nikita.QuickOrderSystem.enums.Role;
import ru.nikita.QuickOrderSystem.repository.DishRepository;
import ru.nikita.QuickOrderSystem.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final DishRepository dishRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DataInitializer(DishRepository dishRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.dishRepository = dishRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (dishRepository.count() == 0) {
            List<Dish> dishes = Arrays.asList(
                    // Завтраки
                    new Dish("Овсянка с ягодами", "Завтрак", "Овсяные хлопья с молоком, свежими ягодами и мёдом", 199.0),
                    new Dish("Яичница-глазунья", "Завтрак", "Яйца, жаренные на сливочном масле, с зеленью", 149.0),

                    // Салаты
                    new Dish("Цезарь", "Салаты", "Куриная грудка, романо, гренки, пармезан, соус цезарь", 349.0),
                    new Dish("Греческий", "Салаты", "Помидоры, огурцы, красный лук, оливки, фета, оливковое масло", 299.0),

                    // Основные блюда
                    new Dish("Бефстроганов", "Основные блюда", "Мягкая говядина в сливочном соусе, подаётся с картофельным пюре", 499.0),
                    new Dish("Паста Карбонара", "Основные блюда", "Спагетти, панчетта, яйцо, пармезан, чёрный перец", 399.0),

                    // Напитки
                    new Dish("Латте", "Напитки", "Эспрессо с молочной пеной", 179.0),
                    new Dish("Лимонад домашний", "Напитки", "Свежевыжатый лимонный сок с мятой и мёдом", 129.0)
            );
            dishRepository.saveAll(dishes);
        }
        if (userRepository.findByEmail("admin@example.com").isEmpty()) {
            User admin = new User();
            admin.setFirstName("Nikita");
            admin.setLastName("Admin");
            admin.setEmail("admin@example.com");
            admin.setRole(Role.ADMIN);
            admin.setPasswordHash(passwordEncoder.encode("admin"));
            userRepository.save(admin);
        }
    }
}
