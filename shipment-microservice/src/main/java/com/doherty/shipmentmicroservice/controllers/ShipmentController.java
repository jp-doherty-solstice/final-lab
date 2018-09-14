package com.doherty.shipmentmicroservice.controllers;

import com.doherty.shipmentmicroservice.model.Shipment;
import com.doherty.shipmentmicroservice.model.ShipmentSummary;
import com.doherty.shipmentmicroservice.services.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShipmentController {

    @Autowired
    ShipmentService shipmentService;

    @PostMapping("/shipments")
    public void createShipment(@RequestBody Shipment shipment) {
        shipmentService.createShipment(shipment);
    }

    @RequestMapping(value = "/shipmentSummary/{id}", method = RequestMethod.GET)
    public ShipmentSummary getShipmentSummary(@PathVariable(value="id") Long id) {
        return shipmentService.getShipmentSummary(id);
    }

    @GetMapping("/shipments")
    public List<ShipmentSummary> getAllShipmentForAccount(@RequestParam("accountId") Long accountId) {
        return shipmentService.getAllShipmentsForAccount(accountId);
    }

}
