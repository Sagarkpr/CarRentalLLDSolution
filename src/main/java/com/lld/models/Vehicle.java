package com.lld.models;

import com.lld.models.enums.VehicleType;

public class Vehicle {
    private String chassisNumber;
    private VehicleType vehicleType;

    public String getChassisNumber() {
        return chassisNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle(String chassisNumber, VehicleType vehicleType) {
        this.chassisNumber = chassisNumber;
        this.vehicleType = vehicleType;
    }
}
