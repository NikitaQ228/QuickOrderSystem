package ru.nikita.QuickOrderSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateDto {
    private List<OrderItemDto> orderItems;
    private String address;
    private String phone;
    private String comment;
    private String nameRecipient;
}