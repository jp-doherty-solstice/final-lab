package com.doherty.shipmentmicroservice.repository;

import com.doherty.shipmentmicroservice.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

    @Query("select s from Shipment s where s.account = ?1")
    List<Shipment> findAllShipmentsForAccount(Long accountId);

}
