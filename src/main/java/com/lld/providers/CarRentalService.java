package com.lld.providers;

import com.lld.models.Receipt;
import com.lld.models.Vehicle;
import com.lld.models.enums.VehicleType;

import java.time.LocalDateTime;
import java.util.List;

public class CarRentalService {
    private BookingService bookingService;
    private UserService userService;
    private InventoryService inventoryService;
    public CarRentalService() {
        this.inventoryService = new InventoryService();
        bookingService = new BookingService(inventoryService);
        userService = new UserService();
    }
    public boolean addVehicle(Vehicle vehicle){
        try {
            inventoryService.addVehicle(vehicle);
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
    }

    public Receipt bookVehicle(String userId, VehicleType vehicleType, String source, String destination, LocalDateTime startDate, LocalDateTime endDate) throws Exception{
        return bookingService.book(userId, vehicleType, source, destination, startDate, endDate);
    }

    public String cancelBooking(String userId, String bookingId) throws Exception{
        return bookingService.cancelBooking(userId, bookingId);
    }
    public Receipt completeBooking(String userId, String bookingId) throws Exception{
        if(!checkVehicleReturned()) {
            throw  new Exception("Vehicle Not returned");
        }
        return bookingService.completeBooking(userId, bookingId);
    }

    public Boolean checkVehicleReturned() {
        return true;
    }

    public List<Vehicle> getAvailableVehicle(VehicleType vehicleType) throws Exception{
        return inventoryService.getAvailableVehicleList(vehicleType);
    }
}
