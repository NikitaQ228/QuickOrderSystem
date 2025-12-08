package ru.nikita.QuickOrderSystem.services;

import ru.nikita.QuickOrderSystem.dto.OrderCreateDto;
import ru.nikita.QuickOrderSystem.dto.OrderDto;
import ru.nikita.QuickOrderSystem.entity.User;

public interface OrderService {
    OrderDto createOrder(OrderCreateDto dto, User user);
}
