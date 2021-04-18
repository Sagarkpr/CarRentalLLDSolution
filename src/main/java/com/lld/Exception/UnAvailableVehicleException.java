package com.lld.Exception;

public class UnAvailableVehicleException extends Exception{
    public UnAvailableVehicleException() {
        super("Car of this type is not available currently");
    }
}
