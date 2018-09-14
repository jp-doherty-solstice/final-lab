package com.doherty.shipmentmicroservice.services;

import com.doherty.shipmentmicroservice.model.LineItemSummary;
import com.doherty.shipmentmicroservice.model.Shipment;
import com.doherty.shipmentmicroservice.model.ShipmentSummary;
import com.doherty.shipmentmicroservice.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShipmentService {

    @Autowired
    ShipmentRepository shipmentRepository;

    @Autowired
    LineItemService lineItemService;

    public void createShipment(Shipment shipment) {
        Shipment savedShipment = shipmentRepository.save(shipment);
        Long savedShipmentId = savedShipment.getId();
        List<Long> lineItemIds = savedShipment.getLineItems();
        assignShipmentToLineItems(savedShipmentId, lineItemIds);
    }

    public void assignShipmentToLineItems(Long shipmentId, List<Long> lineItemIds) {
        for (Long lineItemId : lineItemIds) {
            lineItemService.assignShipmentToLineItems(lineItemId, shipmentId);
        }
    }

    public ShipmentSummary getShipmentSummary(Long id) {
        Shipment shipment = shipmentRepository.getOne(id);
        ShipmentSummary summary = new ShipmentSummary();
        summary.setShippedDate(shipment.getShipppedDate());
        summary.setDeliveryDate(shipment.getDeliveryDate());
        summary.setLineItems(getLineItemSummaries(shipment.getLineItems()));
        return summary;
    }

    private List<LineItemSummary> getLineItemSummaries(List<Long> lineItemIds) {
        List<LineItemSummary> summaries = new ArrayList<>();
        for (Long id : lineItemIds) {
            summaries.add(lineItemService.getLineItemSummary(id));
        }
        return summaries;
    }

    public List<ShipmentSummary> getAllShipmentsForAccount(Long accountId) {
        List<Shipment> shipments = shipmentRepository.findAllShipmentsForAccount(accountId);
        List<ShipmentSummary> summaries = new ArrayList<>();
        for (Shipment shipment : shipments) {
            ShipmentSummary summary = new ShipmentSummary();
            summary.setShippedDate(shipment.getShipppedDate());
            summary.setDeliveryDate(shipment.getDeliveryDate());
            summary.setLineItems(getLineItemSummaries(shipment.getLineItems()));
            summaries.add(summary);
        }
        return summaries;
    }

}
