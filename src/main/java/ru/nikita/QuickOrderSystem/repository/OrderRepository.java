package ru.nikita.QuickOrderSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nikita.QuickOrderSystem.entity.Order;
import ru.nikita.QuickOrderSystem.enums.Status;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    //Заказы пользователя, отсортированные по дате
    List<Order> findByUserIdOrderByDateTimeDesc(Long userId);

    //Заказы отфильтрованные по статусу, отсортированные по дате
    List<Order> findByStatusOrderByDateTimeDesc(Status status);

    //Заказы отфильтрованные по периоду
    List<Order> findByDateTimeBetweenOrderByDateTimeDesc(
            LocalDateTime start, LocalDateTime end);

    // статус + клиент
    List<Order> findByStatusAndUserIdOrderByDateTimeDesc(
            Status status, Long userId);

    // статус + период
    List<Order> findByStatusAndDateTimeBetweenOrderByDateTimeDesc(
            Status status, LocalDateTime start, LocalDateTime end);

    // клиент + период
    List<Order> findByUserIdAndDateTimeBetweenOrderByDateTimeDesc(
            Long userID, LocalDateTime start, LocalDateTime end);

    // статус + клиент + период
    List<Order> findByStatusAndUserIdAndDateTimeBetweenOrderByDateTimeDesc(
            Status status, Long userId,
            LocalDateTime start, LocalDateTime end);
}