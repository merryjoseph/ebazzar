package com.sayone.ebazzar.repository;

import com.sayone.ebazzar.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<CartEntity,Long> {

    Optional<CartEntity> findByCartId(Long cartId);

    @Query(value = "select * from cart c where c.user_id = ?1 and c.cart_status = ?2",nativeQuery = true)
    List<CartEntity> findByUserIdAndStatus(Long userId, String status);
}
