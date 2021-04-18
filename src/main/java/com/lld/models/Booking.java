package com.lld.models;

import com.lld.models.enums.BookingStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class Booking {

    private String source;
    private String destin;
    private Receipt receipt;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Vehicle vehicle;
    private BookingStatus bookingStatus;

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getBookingId() {
        return bookingId;
    }

    private String bookingId;

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestin(String destin) {
        this.destin = destin;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getSource() {
        return source;
    }

    public String getDestin() {
        return destin;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }


    public Booking(String source, String destin,LocalDateTime startDate,LocalDateTime endDate) {
        this.source = source;
        this.destin = destin;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bookingId = UUID.randomUUID().toString();
    }
}
