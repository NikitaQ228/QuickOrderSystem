package ru.nikita.QuickOrderSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nikita.QuickOrderSystem.entity.User;
import ru.nikita.QuickOrderSystem.enums.Role;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRole(Role role);

    // поиск менеджеров по имени или фамилии (частичное совпадение, без учёта регистра)
    List<User> findByRoleAndFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(
            Role role, String firstName, String lastName
    );

    // поиск по части email, без регистра
    List<User> findByRoleAndEmailContainingIgnoreCase(Role role, String emailPart);
}
