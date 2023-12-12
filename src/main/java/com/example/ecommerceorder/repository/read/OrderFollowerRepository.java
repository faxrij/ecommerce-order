package com.example.ecommerceorder.repository.read;

import com.example.ecommerceorder.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderFollowerRepository extends JpaRepository<Order, Long> {
}
