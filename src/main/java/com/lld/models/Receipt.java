package com.lld.models;

import java.time.LocalDateTime;

public class Receipt {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String src;
    private String destination;

    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }

    private double price;
    private String userId;
    private String bookingId;

    public Receipt(LocalDateTime startDate, LocalDateTime endDate, String src, String destination, double price, String userId, String bookingId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.src = src;
        this.destination = destination;
        this.price = price;
        this.userId = userId;
        this.bookingId = bookingId;
    }
}
