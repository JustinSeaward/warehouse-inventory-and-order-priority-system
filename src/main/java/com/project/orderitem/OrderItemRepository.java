package com.project.orderitem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<Long, OrderItem> {
}
