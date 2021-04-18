package com.lld.providers;

import com.lld.Exception.InvalidVehicleDetailsException;
import com.lld.Exception.UnAvailableVehicleException;
import com.lld.models.Vehicle;
import com.lld.models.enums.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryService {
    Map<VehicleType, List<Vehicle>> availableVehicle;
    Map<VehicleType, Map<String, List<Vehicle>>> inventoryVehicle;

    public InventoryService() {
        availableVehicle = new HashMap<>();
        inventoryVehicle = new HashMap<>();
    }

    public void addVehicle(Vehicle vehicle) throws Exception{
        if(validate(vehicle)) {
            throw new InvalidVehicleDetailsException();
        }
        VehicleType type = vehicle.getVehicleType();
        if(!inventoryVehicle.containsKey(type)) {
            inventoryVehicle.put(type, new HashMap<>());
            inventoryVehicle.get(type).put(vehicle.getChassisNumber(), new ArrayList<Vehicle>());
            availableVehicle.put(type, new ArrayList<Vehicle>());
        }
        List<Vehicle> vehicleList = inventoryVehicle.get(type).get(vehicle.getChassisNumber());
        vehicleList.add(vehicle);
        availableVehicle.get(type).add(vehicle);
    }

    public void addAvailableVehicle(Vehicle vehicle) {
        availableVehicle.get(vehicle.getVehicleType()).add(vehicle);
    }

    public Boolean validate(Vehicle vehicle) {
        if (vehicle.getChassisNumber() == "" || inventoryVehicle.get(vehicle.getVehicleType()).containsKey(vehicle.getChassisNumber())) {
            return false;
        }
        return true;
    }

    public Vehicle getAvailableVehicle(VehicleType vehicleType) throws Exception{
        if(!availableVehicle.containsKey(vehicleType) || availableVehicle.get(vehicleType).size()<1) {
            throw new UnAvailableVehicleException();
        }
        Vehicle vehicle = availableVehicle.get(vehicleType).get(0);
        availableVehicle.get(vehicleType).remove(0);
        return vehicle;
    }

    public List<Vehicle> getAvailableVehicleList(VehicleType vehicleType) throws Exception{
        if(!availableVehicle.containsKey(vehicleType) || availableVehicle.get(vehicleType).size()<1) {
            throw new UnAvailableVehicleException();
        }
        return availableVehicle.get(vehicleType);
    }
}