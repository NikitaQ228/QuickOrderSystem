package ru.nikita.QuickOrderSystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nikita.QuickOrderSystem.enums.Role;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    private String passwordHash;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}
