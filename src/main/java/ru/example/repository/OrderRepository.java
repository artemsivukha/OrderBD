package ru.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.model.Order;

public interface OrderRepository extends JpaRepository <Order, Long> {
}
