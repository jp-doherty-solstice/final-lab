package com.doherty.shipmentmicroservice.model;

public class LineItemSummary {

    private String productName;
    private int quantity;

    public LineItemSummary() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
