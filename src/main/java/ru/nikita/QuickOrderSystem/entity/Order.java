package ru.nikita.QuickOrderSystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nikita.QuickOrderSystem.dto.OrderCreateDto;
import ru.nikita.QuickOrderSystem.enums.Status;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    private Status status;

    private String address;

    private String comment;

    private String phone;

    private String nameRecipient;

    private LocalDateTime dateTime;

    public Order(OrderCreateDto dto) {
        this.address = dto.getAddress();
        this.comment = dto.getComment();
        this.phone = dto.getPhone();
        this.nameRecipient = dto.getNameRecipient();
        this.status = Status.CREATED;
        this.dateTime = LocalDateTime.now();
    }
}
