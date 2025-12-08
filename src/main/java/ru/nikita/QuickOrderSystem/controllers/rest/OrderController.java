package ru.nikita.QuickOrderSystem.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nikita.QuickOrderSystem.dto.OrderCreateDto;
import ru.nikita.QuickOrderSystem.dto.OrderDto;
import ru.nikita.QuickOrderSystem.model.MyUserDetails;
import ru.nikita.QuickOrderSystem.services.impl.OrderServiceImpl;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderServiceImpl orderService;

    @Autowired
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderDto createOrder(@RequestBody OrderCreateDto dto,
                                @AuthenticationPrincipal MyUserDetails userDetails) {
        return orderService.createOrder(dto, userDetails.getUser());
    }
}
