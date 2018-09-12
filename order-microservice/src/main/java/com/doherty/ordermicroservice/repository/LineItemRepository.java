package com.doherty.ordermicroservice.repository;

import com.doherty.ordermicroservice.entity.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineItemRepository extends JpaRepository<LineItem, Long> {
}
