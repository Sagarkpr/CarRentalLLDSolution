package com.lld.providers;

import com.lld.models.Booking;
import com.lld.models.Receipt;
import com.lld.models.Vehicle;
import com.lld.models.enums.BookingStatus;
import com.lld.models.enums.VehicleType;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class BookingService {
    private InventoryService inventoryService;
    private Map<String, Map<String, Booking>> userBookings;
    private PaymentService paymentService;

    public BookingService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
        this.userBookings = new HashMap<>();
        this.paymentService = new PaymentService();
    }

    public Receipt book(String userId, VehicleType vehicleType, String source, String destin, LocalDateTime startDate, LocalDateTime endDate) throws Exception{
        Vehicle vehicle = inventoryService.getAvailableVehicle(vehicleType);
        Booking book = new Booking(source,destin,startDate,endDate);
        book.setVehicle(vehicle);
        double price = getPrice(vehicleType, source, destin, startDate, endDate);
        this.paymentService.pay(book.getBookingId(), price);
        Receipt receipt = this.generateReceipt(userId,source, destin,startDate,endDate, book.getBookingId(), price);
        book.setReceipt(receipt);
        Map<String, Booking> bookingMap = new HashMap<>();
        bookingMap.put(book.getBookingId(), book);
        book.setBookingStatus(BookingStatus.BOOKED);
        userBookings.put(userId, bookingMap);
        return receipt;
    }

    public String cancelBooking(String bookingId, String userId){
        if(!userBookings.containsKey(userId) || !userBookings.get(userId).containsKey(bookingId))
        {
            return "Invalid UserId or BookingId";
        }
        Booking book = userBookings.get(userId).get(bookingId);
        if(book.getBookingStatus() == BookingStatus.CANCELLED || book.getBookingStatus() == BookingStatus.COMPLETED) {
            return "Booking already Cancelled or completed";
        }
        book.setBookingStatus(BookingStatus.CANCELLED);

        inventoryService.addAvailableVehicle(book.getVehicle());
        paymentService.refund(bookingId);

        return "Booking Cancelled successfuly";
    }

    public Receipt completeBooking(String bookingId, String userId) throws Exception{
        if(!userBookings.containsKey(userId) || !userBookings.get(userId).containsKey(bookingId))
        {
            throw new Exception("Invalid UserId or BookingId");
        }
        Booking book = userBookings.get(userId).get(bookingId);
        if(book.getBookingStatus() != BookingStatus.CANCELLED || book.getBookingStatus() == BookingStatus.COMPLETED) {
            throw new Exception("Booking already Cancelled or completed");
        }
        double price = checkExtraCharges(book);
        if(price!=0) {
            throw new Exception("please pay extracharges " + price);
        }
        inventoryService.addAvailableVehicle(book.getVehicle());
        book.setBookingStatus(BookingStatus.COMPLETED);
        return book.getReceipt();
    }

    public Receipt payExtraCharges(double price, String bookingId, String userId) throws Exception{
        if(!userBookings.containsKey(userId) || !userBookings.get(userId).containsKey(bookingId))
        {
            throw new Exception("Invalid UserId or BookingId");
        }
        Booking book = userBookings.get(userId).get(bookingId);
        if(book.getBookingStatus() != BookingStatus.CANCELLED || book.getBookingStatus() == BookingStatus.COMPLETED) {
            throw new Exception("Booking already Cancelled or completed");
        }
        paymentService.pay(bookingId, price);
        Receipt receipt = book.getReceipt();
        receipt.setPrice(receipt.getPrice() + price);
        return receipt;
    }

    public double checkExtraCharges(Booking book) {
        return 0;
    }

    public double getPrice(VehicleType vehicleType, String source, String destin, LocalDateTime startDate, LocalDateTime endDate) {
        return 10000;
    }

    public Receipt generateReceipt(String userId, String source, String destin, LocalDateTime startDate, LocalDateTime endDate, String bookingId, double price) {
        return new Receipt(startDate,endDate, source, destin, price, userId, bookingId);
    }
}
