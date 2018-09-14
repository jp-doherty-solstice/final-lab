package com.doherty.shipmentmicroservice.model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;

@Entity
public class Shipment {

    @Id
    @GeneratedValue
    private Long id;

    private Long account;

    private Long address;

    @ElementCollection(targetClass = Long.class)
    private List<Long> lineItems;

    private Timestamp shipppedDate;

    private Timestamp deliveryDate;

    public Shipment() {
        shipppedDate = new Timestamp(System.currentTimeMillis());
        ZonedDateTime zonedDateTime = shipppedDate.toInstant().atZone(ZoneId.of("UTC"));
        deliveryDate = Timestamp.from(zonedDateTime.plus(3, ChronoUnit.DAYS).toInstant());
    }

    public Long getId() {
        return id;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public Long getAddress() {
        return address;
    }

    public void setAddress(Long address) {
        this.address = address;
    }

    public List<Long> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<Long> lineItems) {
        this.lineItems = lineItems;
    }

    public Timestamp getShipppedDate() {
        return shipppedDate;
    }

    public void setShipppedDate(Timestamp shipppedDate) {
        this.shipppedDate = shipppedDate;
    }

    public Timestamp getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Timestamp deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

}
