package ru.nikita.QuickOrderSystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nikita.QuickOrderSystem.dto.OrderCreateDto;
import ru.nikita.QuickOrderSystem.dto.OrderDto;
import ru.nikita.QuickOrderSystem.entity.Dish;
import ru.nikita.QuickOrderSystem.entity.Order;
import ru.nikita.QuickOrderSystem.entity.OrderItem;
import ru.nikita.QuickOrderSystem.entity.User;
import ru.nikita.QuickOrderSystem.repository.DishRepository;
import ru.nikita.QuickOrderSystem.repository.OrderRepository;
import ru.nikita.QuickOrderSystem.services.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final DishRepository dishRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, DishRepository dishRepository) {
        this.orderRepository = orderRepository;
        this.dishRepository = dishRepository;
    }


    @Override
    public OrderDto createOrder(OrderCreateDto dto, User user) {
        Order order = new Order(dto);
        order.setUser(user);

        List<OrderItem> items = dto.getOrderItems().stream()
                .map(itemDto -> {
                    Dish dish = dishRepository.findById(itemDto.getDishId())
                            .orElseThrow(() -> new IllegalArgumentException("Dish not found: " + itemDto.getDishId()));

                    OrderItem item = new OrderItem();
                    item.setOrder(order);
                    item.setDish(dish);
                    item.setQuantity(itemDto.getQuantity());
                    return item;
                })
                .toList();

        order.setOrderItems(items);

        return new OrderDto(orderRepository.save(order));
    }
}
