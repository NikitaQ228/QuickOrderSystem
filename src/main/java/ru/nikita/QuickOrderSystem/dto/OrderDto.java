package ru.nikita.QuickOrderSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nikita.QuickOrderSystem.entity.Order;
import ru.nikita.QuickOrderSystem.enums.Status;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;

    private List<OrderItemDto> orderItems;

    private Status status;

    private String address;

    private String comment;

    private String phone;

    private String nameRecipient;

    private LocalDateTime dateTime;

    public OrderDto(Order order) {
        this.id = order.getId();
        this.status = order.getStatus();
        this.address = order.getAddress();
        this.comment = order.getComment();
        this.phone = order.getPhone();
        this.nameRecipient = order.getNameRecipient();
        this.dateTime = order.getDateTime();

        if (order.getOrderItems() != null) {
            this.orderItems = order.getOrderItems().stream()
                    .map(oi -> new OrderItemDto(oi.getDish(), oi.getQuantity()))
                    .toList();
        } else {
            this.orderItems = List.of();
        }
    }
}
