package com.sayone.ebazzar.repository;

import com.sayone.ebazzar.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    Optional<OrderEntity> findByOrderId(Long id);

    @Query(value = "select * from orders o where o.cart_id = ?1", nativeQuery = true)
    OrderEntity findByCartId(long cartId);

    @Query(value = "select * from orders o where o.cart_id = ?1 and o.order_status = ?2", nativeQuery = true)
    OrderEntity findBycartIdandStatus(long cartId, String status);
}
